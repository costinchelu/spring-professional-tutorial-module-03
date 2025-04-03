package question28.service;

import lombok.AllArgsConstructor;
import question28.dao.custom.CustomEmployeeDao;
import question28.dao.regular.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// until we will override the default behaviour of the repository, we will use the default implementation so both Dao will implement SimpleJpaRepository
// but the CustomEmployeeDao will take its implementation from the CustomEmployeeFindRepositoryImpl

// after the override in the JpaConfiguration, we will use CustomBaseJpaRepository for both Dao
@AllArgsConstructor
@Service
public class EmployeeService {

    private EmployeeDao employeeDao;

    private CustomEmployeeDao customEmployeeDao;

    public void queryEmployee() {
        System.out.println("Searching for John Doe employee with SimpleJpa implementation...");
        System.out.println(employeeDao.findByFirstNameAndLastName("John", "Doe"));

        System.out.println("Searching for John Doe employee with custom dao implementation...");
        System.out.println(customEmployeeDao.findByFirstNameAndLastName("John", "Doe"));
    }
}
