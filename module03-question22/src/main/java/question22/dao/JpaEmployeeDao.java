package question22.dao;

import question22.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface JpaEmployeeDao extends CrudRepository<Employee, Integer> {
}
