package question23.jpa.tx.db.employees.dao;

import question23.jpa.tx.db.employees.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
}
