package question24;

import lombok.AllArgsConstructor;
import question24.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@AllArgsConstructor
@SpringBootApplication
public class Runner implements CommandLineRunner {

    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }

    @Override
    public void run(String... args) {
        employeeService.saveAllEmployees();
        employeeService.listAllEmployees();
    }
}
