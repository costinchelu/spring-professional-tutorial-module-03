package question23.jpa.tx.service;

import lombok.AllArgsConstructor;
import question23.jpa.tx.db.employees.dao.EmployeeDao;
import question23.jpa.tx.db.employees.ds.Employee;
import question23.jpa.tx.db.products.dao.ProductDao;
import question23.jpa.tx.db.products.ds.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@AllArgsConstructor
@Service
public class WarehouseService {

    private EmployeeDao employeeDao;

    private ProductDao productDao;

    @Transactional(transactionManager = "productsTransactionManager")
    public void saveData() {
        Employee emp1 = new Employee(1, "John", "Doe", "John.Doe@corp.com", "555-55-55", Date.valueOf("2019-06-05"), 70000);
        Product prod1 = new Product(1, "Jet Ski", 20, 4799f, true);

        System.out.println("Saving employee 1");
        employeeDao.save(emp1);

        System.out.println("Saving product 1");
        productDao.save(prod1);

//        System.out.println("Throwing exception to revert transaction (only the product will be reverted)");
//        throw new IllegalArgumentException();
    }

    @Transactional(transactionManager = "productsTransactionManager")
    public void listAllData() {
        System.out.println("Listing all employees...");
        employeeDao.findAll().forEach(System.out::println);

        System.out.println("Listing all products...");
        productDao.findAll().forEach(System.out::println);
    }
}
