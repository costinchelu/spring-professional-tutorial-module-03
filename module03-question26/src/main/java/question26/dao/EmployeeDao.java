package question26.dao;

import question26.ds.Employee;
import question26.ds.EmployeeKey;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, EmployeeKey> {
}
