package question12.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import static question12.util.CountDownLatchUtil.await;
import static question12.util.CountDownLatchUtil.countDown;

@Service
//@Transactional(isolation = Isolation.SERIALIZABLE)
//@Transactional(isolation = Isolation.REPEATABLE_READ)
//@Transactional(isolation = Isolation.READ_COMMITTED)
@Transactional(isolation = Isolation.READ_UNCOMMITTED)
public class TransactionIsolationExample extends AbstractIsolationExample {

    // whole class is annotated with @Transactional so calling readOperations will start the transaction

    public void readOperations() {
        System.out.println(">> Starting Reading Thread");

        // read data (all employees) before the second read operation
        // countDown latches are used to synchronize read operation with the write operations
        System.out.println("> First Read Operation - second transaction/thread DID NOT SAVE DATA YET");
        readOperation();
        countDown(fistReadOnUnsavedAndNotCommittedLatch);

        await(writeDoneNotCommittedLatch);
        System.out.println("> Second Read Operation - second transaction/thread did save data, but DID NOT COMMIT");
        readOperation();
        countDown(secondReadOnSavedButNotCommittedLatch);

        await(writeDoneAndCommittedLatch);
        System.out.println("> Third Read Operation - second transaction DID SAVE AND COMMIT DATA");
        readOperation();

        System.out.println(">> Finishing Reading");
    }

    public void nextReadOperation() {
        System.out.println(">> Fourth Read Operation - second transaction did save and commit data, NEW READ TRANSACTION CREATED");
        readOperation();
        System.out.println(">> Finishing 4th Reading");
    }

    public void writeOperations() {
        System.out.println(">> Starting Writing Thread");

        // wait for the first read operation to be made
        await(fistReadOnUnsavedAndNotCommittedLatch);
        System.out.println("> Write Operation");
        // make the write (update)
        writeOperation();
        // wait for the second read to be made
        countDown(writeDoneNotCommittedLatch);

        // wait for the second read operation to be made
        await(secondReadOnSavedButNotCommittedLatch);

        System.out.println(">> Finishing Writing");
    }
}
