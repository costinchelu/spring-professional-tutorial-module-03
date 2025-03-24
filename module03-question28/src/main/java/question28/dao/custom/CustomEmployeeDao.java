package question28.dao.custom;

import question28.ds.Employee;
import org.springframework.data.repository.CrudRepository;

public interface CustomEmployeeDao extends CrudRepository<Employee, Integer>, CustomEmployeeFindRepository {
}
