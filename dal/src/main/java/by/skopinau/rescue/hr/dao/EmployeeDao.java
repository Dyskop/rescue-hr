package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.Employee;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeDao extends BaseDao<Employee> {
    List<Employee> findBySurname(String surname);

    List<Employee> findByName(String name);

    List<Employee> findByPatronymic(String patronymic);

    List<Employee> findByBirthday(LocalDate date);

    List<Employee> findByRank(String rankTitle);

    List<Employee> findByPosition(String positionTitle);

    List<Employee> findBySubdivision(String subdivisionTitle);

    @Override
    List<Employee> findAll();
}