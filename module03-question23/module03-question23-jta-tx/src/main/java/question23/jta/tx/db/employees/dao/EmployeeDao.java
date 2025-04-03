package question23.jta.tx.db.employees.dao;

import question23.jta.tx.db.employees.ds.Employee;
import org.springframework.data.repository.CrudRepository;


public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
