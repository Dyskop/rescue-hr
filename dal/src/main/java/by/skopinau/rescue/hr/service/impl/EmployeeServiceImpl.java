package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.dao.EmployeeDao;
import by.skopinau.rescue.hr.exception.EmployeeNotFoundException;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee findBySurname(String surname) throws EmployeeNotFoundException {
        return employeeDao.findBySurname(surname);
    }
}
