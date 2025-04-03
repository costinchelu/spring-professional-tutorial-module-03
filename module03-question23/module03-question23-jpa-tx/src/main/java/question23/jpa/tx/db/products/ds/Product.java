package question23.jpa.tx.db.products.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Product {

    @Id
    private int id;
    private String name;
    private int quantity;
    private float price;
    private boolean available;
}
