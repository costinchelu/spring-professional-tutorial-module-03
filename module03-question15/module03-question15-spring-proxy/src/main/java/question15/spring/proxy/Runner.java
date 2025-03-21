package question15.spring.proxy;

import question15.spring.proxy.service.EmployeeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan
@EnableAspectJAutoProxy
public class Runner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Runner.class);
        context.registerShutdownHook();

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        employeeService.transaction1And2();
            /*
            Starting transaction1And2
            transaction1 method called
            transaction2 method called
            Completed transaction1And2
             */

        employeeService.transaction1And2WithPrecedingTransaction();
            /*
            Data Source Trace: Connection javax.sql.DataSource.getConnection()
            Starting transaction1And2WithPrecedingTransaction
            transaction1 method called
            transaction2 method called
            Completed transaction1And2WithPrecedingTransaction
            Connection Trace: public abstract void java.sql.Connection.commit() throws java.sql.SQLException
            Connection Trace: public abstract void java.sql.Connection.close() throws java.sql.SQLException
             */
    }
}
