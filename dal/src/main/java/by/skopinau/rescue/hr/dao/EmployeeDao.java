package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.*;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeDao extends BaseDao<Employee> {
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

    List<Employee> findByState(State state);

    @Override
    List<Employee> findAll();
}