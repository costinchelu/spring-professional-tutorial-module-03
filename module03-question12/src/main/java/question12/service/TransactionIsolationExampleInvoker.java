package question12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static question12.util.CountDownLatchUtil.await;
import static question12.util.CountDownLatchUtil.countDown;

@Component
public class TransactionIsolationExampleInvoker {

    @Autowired
    private TransactionIsolationExample transactionIsolationExample;

    private ExecutorService executorService = Executors.newFixedThreadPool(2);

    public void execute() {
        System.out.println(">>> Starting Repeatable Read Example");

        // 1st thread = read operations
        executorService.execute(() -> {
            transactionIsolationExample.readOperations();
            transactionIsolationExample.nextReadOperation();
            countDown(transactionIsolationExample.getReadWriteLatch());
        });

        // 2nd thread = write operations
        executorService.execute(() -> {
            transactionIsolationExample.writeOperations();
            countDown(transactionIsolationExample.getWriteDoneAndCommittedLatch());
            countDown(transactionIsolationExample.getReadWriteLatch());
        });

        // main thread waits for the both threads to finish
        await(transactionIsolationExample.getReadWriteLatch());

        executorService.shutdown();
    }
}
