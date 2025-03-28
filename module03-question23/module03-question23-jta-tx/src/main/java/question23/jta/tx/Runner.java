package question23.jta.tx;

import question23.jta.tx.service.WarehouseService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan
@EnableTransactionManagement
@EnableAspectJAutoProxy
public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        WarehouseService warehouseService = context.getBean(WarehouseService.class);

        warehouseService.purgeData();

        try {
            warehouseService.saveData();
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + " exception caught");
        }

        warehouseService.listAllData();
    }
}
