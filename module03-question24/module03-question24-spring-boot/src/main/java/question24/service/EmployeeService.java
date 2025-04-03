package question24.service;

import lombok.AllArgsConstructor;
import question24.dao.EmployeeDao;
import question24.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeDao employeeDao;

    public void saveAllEmployees() {
        Employee emp1 = new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000);
        Employee emp2 = new Employee(2, "Willow", "Zhang", "Willow.Zhang@corp.com", "555-55-56", Date.valueOf("2019-07-12"), 80000);
        Employee emp3 = new Employee(3, "Jayvon", "Grant", "Jayvon.Grant@corp.com", "555-55-57", Date.valueOf("2019-07-17"), 90000);
        Employee emp4 = new Employee(4, "Shaylee", "Mcclure", "Shaylee.Mcclure@corp.com", "555-55-58", Date.valueOf("2019-07-19"), 120000);
        Employee emp5 = new Employee(5, "Miley", "Krueger", "Miley.Krueger@corp.com", "555-55-59", Date.valueOf("2019-07-20"), 110000);
        List<Employee> employeeList = List.of(emp1, emp2, emp3, emp4, emp5);

        System.out.println("Saving all employees...");

        employeeDao.saveAll(employeeList);
    }

    public void listAllEmployees() {
        System.out.println("Listing all employees...");

        employeeDao.findAll().forEach(System.out::println);
    }
}
