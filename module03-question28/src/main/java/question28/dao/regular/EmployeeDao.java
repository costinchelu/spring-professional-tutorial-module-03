package question28.dao.regular;

import question28.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
