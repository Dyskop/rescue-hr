package by.skopinau.rescue.hr.dao;


import by.skopinau.rescue.hr.exception.EmployeeNotFoundException;
import by.skopinau.rescue.hr.model.Employee;

import java.util.List;

/**
 * Data Access Object for employee.
 */
public interface EmployeeDao {

    /**
     * Get employee by surname.
     * @param surname field for employee
     * @return employee {@link Employee}
     */
    Employee findBySurname(String surname) throws EmployeeNotFoundException;
}
