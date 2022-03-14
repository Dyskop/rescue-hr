package by.skopinau.rescue.hr.util;

import by.skopinau.rescue.hr.exception.EmployeeNotFoundException;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeServiceApp {
    public static void main(String[] args) throws EmployeeNotFoundException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        EmployeeService employeeService = (EmployeeService) context.getBean("employeeService");
        Employee bySurname = employeeService.findBySurname("Иванов");
        System.out.println(bySurname);
    }
}
