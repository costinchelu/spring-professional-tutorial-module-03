package question10.dao;

import question10.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Employee> findAllEmployees() {
        return jdbcTemplate.query("SELECT employee_id, first_name, last_name, email, phone_number, hire_date, salary FROM employee", this::mapEmployee);
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
            System.out.printf("Saved employee [%d]%n", employee.getId());
        else
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numberOfRecordsInserted));
    }

    public void deleteAllEmployees() {
        int numberOfDeletedRows = jdbcTemplate.update("DELETE FROM employee");

        System.out.printf("Employees deleted, number of deleted rows = [%d]%n", numberOfDeletedRows);
    }

    @SneakyThrows
    private Employee mapEmployee(ResultSet resultSet, int i) {
        return new Employee(
                resultSet.getInt("employee_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email"),
                resultSet.getString("phone_number"),
                resultSet.getDate("hire_date"),
                resultSet.getFloat("salary")
        );
    }
}
