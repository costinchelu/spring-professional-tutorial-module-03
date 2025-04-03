package question22.service;

import lombok.AllArgsConstructor;
import question22.dao.JdbcEmployeeDao;
import question22.dao.JpaEmployeeDao;
import question22.ds.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@AllArgsConstructor
@Service
public class EmployeeService {

    private JpaEmployeeDao jpaEmployeeDao;

    private JdbcEmployeeDao jdbcEmployeeDao;

    // example using both JPA and JDBC for inserting entries in the DB
    // notice that although jdbc.save method is explicitly implemented in the jdbcEmployeeDao (jdbcTemplate.update),
    // the save method for the jpaEmployeeDao is automatically created by the JPA
    // each dao's will save 1 employee in the same transaction
    @Transactional
    public void saveEmployeesUnderOneTransaction() {
        Employee emp1 = new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000);
        Employee emp2 = new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000);

        System.out.println("Saving employee with JPA...");
        jpaEmployeeDao.save(emp1);

        System.out.println("Saving employee with JDBC...");
        jdbcEmployeeDao.save(emp2);
    }

    @Transactional
    public void listAllEmployees() {
        jpaEmployeeDao.findAll().forEach(System.out::println);
    }
}
