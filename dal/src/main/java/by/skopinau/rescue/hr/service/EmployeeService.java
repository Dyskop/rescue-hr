package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.exception.EmployeeNotFoundException;
import by.skopinau.rescue.hr.model.Employee;

/**
 * Service for Employee
 */
public interface EmployeeService {
    Employee findBySurname(String surname) throws EmployeeNotFoundException;
}
