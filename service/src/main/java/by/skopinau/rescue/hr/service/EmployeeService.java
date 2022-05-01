package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.Position;
import by.skopinau.rescue.hr.model.Rank;
import by.skopinau.rescue.hr.model.Subdivision;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeService extends BaseService<Employee> {
    List<Employee> findBySurname(String surname);

    List<Employee> findByName(String name);

    List<Employee> findByPatronymic(String patronymic);

    List<Employee> findByBirthday(LocalDate date);

    List<Employee> findByRank(Rank rank);

    List<Employee> findByPosition(Position position);

    List<Employee> findBySubdivision(Subdivision subdivision);

    List<Employee> findByRankTitle(String rankTitle);

    List<Employee> findByPositionTitle(String positionTitle);

    List<Employee> findBySubdivisionTitle(String subdivisionTitle);

    @Override
    List<Employee> findAll();
}