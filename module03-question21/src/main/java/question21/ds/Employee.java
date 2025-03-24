package question21.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Employee {

    // the Entity class needs to have at least on @Id field
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private float salary;

// default constructor will also need to be defined
    @SuppressWarnings("unused")
    public Employee() {
    }
}
