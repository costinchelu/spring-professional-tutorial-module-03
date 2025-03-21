package question14.service;

import lombok.AllArgsConstructor;
import question14.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeDao employeeDao;

    public void callRequiredWithoutCurrentTransaction() {
        employeeDao.requiredTransactionMethod();
    }

    @Transactional
    public void callRequiredWithCurrentTransaction() {
        employeeDao.requiredTransactionMethod();
    }

    public void callSupportsWithoutCurrentTransaction() {
        employeeDao.supportsTransactionMethod();
    }

    @Transactional
    public void callSupportsWithCurrentTransaction() {
        employeeDao.supportsTransactionMethod();
    }

    public void callMandatoryWithoutCurrentTransaction() {
        employeeDao.mandatoryTransactionMethod();
    }

    @Transactional
    public void callMandatoryWithCurrentTransaction() {
        employeeDao.mandatoryTransactionMethod();
    }

    public void callRequiresNewWithoutCurrentTransaction() {
        employeeDao.requiresNewTransactionMethod();
    }

    @Transactional
    public void callRequiresNewWithCurrentTransaction() {
        employeeDao.requiresNewTransactionMethod();
    }

    public void callNotSupportedWithoutCurrentTransaction() {
        employeeDao.notSupportedTransactionMethod();
    }

    @Transactional
    public void callNotSupportedWithCurrentTransaction() {
        employeeDao.notSupportedTransactionMethod();
    }

    public void callNeverWithoutCurrentTransaction() {
        employeeDao.neverTransactionMethod();
    }

    @Transactional
    public void callNeverWithCurrentTransaction() {
        employeeDao.neverTransactionMethod();
    }

    public void callNestedWithoutCurrentTransaction() {
        employeeDao.nestedTransactionMethod();
    }

    @Transactional
    public void callNestedWithCurrentTransaction() {
        employeeDao.nestedTransactionMethod();
    }
}
