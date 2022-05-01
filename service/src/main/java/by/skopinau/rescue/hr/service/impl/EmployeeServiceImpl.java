package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.service.EmployeeService;
import by.skopinau.rescue.hr.dao.EmployeeDao;
import by.skopinau.rescue.hr.dao.jpa.EmployeeDaoJpa;
import by.skopinau.rescue.hr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> implements EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDaoJpa employeeDao) {
        super(employeeDao);
        this.employeeDao = employeeDao;
    }

    public List<Employee> findBySurname(String surname) {
        return employeeDao.findBySurname(surname);
    }

    public List<Employee> findByName(String name) {
        return employeeDao.findByName(name);
    }

    public List<Employee> findByPatronymic(String patronymic) {
        return employeeDao.findByPatronymic(patronymic);
    }

    public List<Employee> findByBirthday(LocalDate date) {
        return employeeDao.findByBirthday(date);
    }

    public List<Employee> findByRank(String rankTitle) {
        return employeeDao.findByRank(rankTitle);
    }

    public List<Employee> findByPosition(String positionTitle) {
        return employeeDao.findByPosition(positionTitle);
    }

    public List<Employee> findBySubdivision(String subdivisionTitle) {
        return employeeDao.findBySubdivision(subdivisionTitle);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}