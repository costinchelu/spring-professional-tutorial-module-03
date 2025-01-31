package question11.dao;

import question11.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveEmployee(Employee employee) {
        if (employee.getId() < 0)
            throw new IllegalArgumentException("Employee Id has to be greater than zero");

        int numberOfRecordsInserted = jdbcTemplate.update(
                "INSERT INTO employee(employee_id, first_name, last_name, email, phone_number, hire_date, salary) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)",
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getSalary()
        );

        if (numberOfRecordsInserted == 1)
            System.out.printf("Saved employee [%d]%n%n", employee.getId());
        else
            throw new IllegalStateException(
                    String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted",
                            numberOfRecordsInserted));
    }
}
