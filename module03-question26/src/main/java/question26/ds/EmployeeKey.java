package question26.ds;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class EmployeeKey implements Serializable {

    private String firstName;
    private String lastName;
}
