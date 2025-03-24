package question23.jta.tx.db.products.dao;

import question23.jta.tx.db.products.ds.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
