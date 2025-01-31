package question11.service;

import question11.dao.EmployeeDao;
import question11.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Service
public class EmployeeService {

    private final EmployeeDao employeeDao;

    private final Employee sampleEmployee = new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000);

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void saveEmployeeWithoutTransaction() {
        System.out.println("SAVING EMPLOYEE WITHOUT TRANSACTION...");
        employeeDao.saveEmployee(sampleEmployee);
    }

    // in a transactional annotated method, the connection to the database is made before the actual method starts running (javax.sql.DataSource.getConnection())
    // also before the execution of the method, java.sql.Connection.setAutocommit() is being called
    @Transactional
    public void saveEmployeeInTransaction() {
        System.out.println("SAVING EMPLOYEE WITH TRANSACTION...");
        employeeDao.saveEmployee(sampleEmployee);
    }
}
