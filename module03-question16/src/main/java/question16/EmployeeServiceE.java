package question16;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeServiceE {

    // Transaction management can only be applied on public methods

    @Transactional
    protected void operationEProtected() {
        System.out.println("Invoked operationEProtected");
    }

    @Transactional
    void operationEPackageVisible() {
        System.out.println("Invoked operationEPackageVisible");
    }

    @Transactional
    private void operationEPrivate() {
        System.out.println("Invoked operationEPrivate");
    }
}
