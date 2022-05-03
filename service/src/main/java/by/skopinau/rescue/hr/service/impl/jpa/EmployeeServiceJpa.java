package by.skopinau.rescue.hr.service.impl.jpa;

import by.skopinau.rescue.hr.dao.EmployeeDao;
import by.skopinau.rescue.hr.dao.jpa.EmployeeDaoJpa;
import by.skopinau.rescue.hr.entity.*;
import by.skopinau.rescue.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceJpa extends BaseServiceJpa<Employee> implements EmployeeService {
    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceJpa(EmployeeDaoJpa employeeDao) {
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

    public List<Employee> findByRank(Rank rank) {
        return employeeDao.findByRank(rank);
    }

    public List<Employee> findByPosition(Position position) {
        return employeeDao.findByPosition(position);
    }

    public List<Employee> findBySubdivision(Subdivision subdivision) {
        return employeeDao.findBySubdivision(subdivision);
    }

    public List<Employee> findByRankTitle(String rankTitle) {
        return employeeDao.findByRankTitle(rankTitle);
    }

    public List<Employee> findByPositionTitle(String positionTitle) {
        return employeeDao.findByPositionTitle(positionTitle);
    }

    public List<Employee> findBySubdivisionTitle(String subdivisionTitle) {
        return employeeDao.findBySubdivisionTitle(subdivisionTitle);
    }

    public List<Employee> findByState(State state) {
        return employeeDao.findByState(state);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}