package question19.service;

import question19.Runner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Runner.class})
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    @Transactional
    public void shouldRollbackTransaction() {
        employeeService.methodWithTransaction();

        // ...will always roll back
    }

    @Test
    @Transactional
    @Rollback(false)
    public void shouldNotRollbackTransaction() {
        employeeService.methodWithTransaction();

        // ...but we can change the default behavior
    }
}