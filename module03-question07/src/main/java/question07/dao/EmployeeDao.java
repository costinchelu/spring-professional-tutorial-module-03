package question07.dao;

import question07.ds.Employee;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String findEmployeeEmail(int id) {
        return jdbcTemplate.queryForObject(
                "select email from employee where employee_id = ?",
                new Object[]{id},
                String.class
        );
    }

    public Employee findEmployee(int id) {
        return jdbcTemplate.queryForObject(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee where employee_id = ?",
                new Object[]{id},
                this::mapEmployee
        );
    }

    public List<String> findEmployeesNames() {
        return jdbcTemplate.queryForList(
                "select first_name from employee",
                String.class);
    }

    // query for map returns a map for a single row
    public Map<String, Object> findEmployeeById(int id) {
        return jdbcTemplate.queryForMap(
                "select * from employee where employee_id = ?",
                id);
    }

    // we can read the resulting data from the rowSet and iterate through records
    public SqlRowSet findEmployeesRowSet() {
        return jdbcTemplate.queryForRowSet("select * from employee");
    }

    public List<Employee> findAllEmployees() {
        return jdbcTemplate.query(
                "select employee_id, first_name, last_name, email, phone_number, hire_date, salary from employee",
                this::mapEmployee);
    }

    // rowMapper for Employee
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
