package question26.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString
public class Employee {

    @EmbeddedId
    private EmployeeKey employeeKey;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private float salary;
}
