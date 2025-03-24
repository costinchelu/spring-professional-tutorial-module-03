package question28.dao.custom;

import question28.ds.Employee;

public interface CustomEmployeeFindRepository {

    Employee findByFirstNameAndLastName(String firstName, String lastName);
}
