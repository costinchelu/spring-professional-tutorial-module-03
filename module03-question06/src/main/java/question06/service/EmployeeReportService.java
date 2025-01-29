package question06.service;

import question06.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeReportService {

    @Autowired
    private EmployeeDao employeeDao;

    public void printReport() {
        System.out.println(">>> Employee Report - START");

        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("findEmployeesEmails(): " + employeeDao.findEmployeesCount());

        System.out.println(">>> Employee Report - STOP");
    }

    @Transactional
    public void printReportInTransaction() {
        System.out.println(">>> Employee Report START - Transactional");

        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());
        System.out.println("Transactional findEmployeesEmails(): " + employeeDao.findEmployeesCount());

        System.out.println(">>> Employee Report STOP - Transactional");
    }
}
