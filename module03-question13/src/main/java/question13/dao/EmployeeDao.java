package question13.dao;

import question13.ds.Employee;
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
        String FIND_ALL = "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee";
        return jdbcTemplate.query(FIND_ALL, this::mapEmployee);
    }

    public void saveEmployee(Employee employee) {
        String INSERT = "insert into employee(employee_id, first_name, last_name, email, phone_number, hire_date, salary) values (?, ?, ?, ?, ?, ?, ?)";
        if (employee.getId() < 0)
            throw new IllegalArgumentException("Employee Id has to be greater than zero");

        int numberOfRecordsInserted = jdbcTemplate.update(
                INSERT,
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getSalary()
        );

        if (numberOfRecordsInserted == 1)
            System.out.println(String.format("Saved employee [%d]", employee.getId()));
        else
            throw new IllegalStateException(String.format("Expected 1 record to be inserted, instead retrieved [%d] number of records inserted", numberOfRecordsInserted));
    }

    public void deleteAllEmployees() {
        int numberOfDeletedRows = jdbcTemplate.update("delete from employee");

        System.out.println(String.format("Employees deleted, number of deleted rows = [%d]", numberOfDeletedRows));
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
