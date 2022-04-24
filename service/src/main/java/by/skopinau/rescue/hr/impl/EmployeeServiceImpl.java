package by.skopinau.rescue.hr.impl;

import by.skopinau.rescue.hr.dao.impl.EmployeeDaoImpl;
import by.skopinau.rescue.hr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee> {
    private final EmployeeDaoImpl employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDaoImpl employeeDao) {
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