package question23.jpa.tx.db.products.dao;

import question23.jpa.tx.db.products.ds.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
