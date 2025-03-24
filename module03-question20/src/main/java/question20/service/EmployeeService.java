package question20.service;

import question20.dao.EmployeeDao;
import question20.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public void operationsWithAutoCommit() {
        saveEmployees();
    }

    @Transactional
    public void operationsWithoutAutoCommit() {
        saveEmployees();
    }

    public void findAllEmployees() {
        System.out.println("> Listing all employees in database");
        List<Employee> allEmployees = employeeDao.findAllEmployees();
        if (allEmployees.isEmpty()) {
            System.out.println("> No employee found");
        } else {
        allEmployees.forEach(System.out::println);
        }
        System.out.println("> Finished listing all employees in database");
    }

    private void saveEmployees() {
        employeeDao.saveEmployee(new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000));
        employeeDao.saveEmployee(new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000));
        employeeDao.saveEmployee(new Employee(3, "Jayvon", "Grant", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000));
        employeeDao.saveEmployee(new Employee(-1, "Shaylee", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000));
        employeeDao.saveEmployee(new Employee(5, "Miley", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000));
    }
}
