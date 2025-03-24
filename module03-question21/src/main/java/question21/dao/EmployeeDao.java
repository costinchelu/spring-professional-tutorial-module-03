package question21.dao;

import question21.ds.Employee;
import org.springframework.data.repository.CrudRepository;

// DAO Classes
public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
