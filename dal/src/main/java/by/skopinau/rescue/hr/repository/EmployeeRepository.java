package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.State;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {
    @Query("select e from Employee e " +
            "join e.position p " +
            "join e.subdivision s " +
            "where p = :#{#state.position} " +
            "and s = :#{#state.subdivision} " +
            "order by e.surname, e.name, e.patronymic")
    List<Employee> findByState(@Param("state") State state);

    @Query("select e from Employee e " +
            "join e.rank r " +
            "join e.position p " +
            "join e.subdivision s " +
            "where lower(e.surname) = lower(:data) or " +
            "lower(e.name) = lower(:data) or " +
            "lower(e.patronymic) = lower(:data) or " +
            "lower(r.rankTitle) = lower(:data) or " +
            "lower(p.positionTitle) = lower(:data) or " +
            "lower(s.subdivisionTitle) = lower(:data) " +
            " order by e.surname, e.name, e.patronymic")
    List<Employee> searchAllPageable(@Param("data") String data, Pageable pageable);

    @Query("select e from Employee e " +
            "join e.rank r " +
            "join e.position p " +
            "join e.subdivision s " +
            "where lower(e.surname) = lower(:data) or " +
            "lower(e.name) = lower(:data) or " +
            "lower(e.patronymic) = lower(:data) or " +
            "lower(r.rankTitle) = lower(:data) or " +
            "lower(p.positionTitle) = lower(:data) or " +
            "lower(s.subdivisionTitle) = lower(:data) " +
            " order by e.surname, e.name, e.patronymic")
    List<Employee> searchAll(@Param("data") String data);
}