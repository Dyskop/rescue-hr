package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends BaseRepository<Employee> {
    List<Employee> findBySurnameOrderBySurnameAscNameAscPatronymicAsc(String surname);

    List<Employee> findByNameOrderBySurnameAscNameAscPatronymicAsc(String name);

    List<Employee> findByPatronymicOrderBySurnameAscNameAscPatronymicAsc(String patronymic);

    List<Employee> findByBirthdayOrderBySurnameAscNameAscPatronymicAsc(LocalDate birthday);

    List<Employee> findByRankOrderBySurnameAscNameAscPatronymicAsc(Rank rank);

    List<Employee> findByPositionOrderBySurnameAscNameAscPatronymicAsc(Position position);

    List<Employee> findBySubdivisionOrderBySurnameAscNameAscPatronymicAsc(Subdivision subdivision);

    @Query("select e from Employee e join e.rank r where r.rankTitle =:rankTitle order by e.surname, e.name, e.patronymic")
    List<Employee> findByRankTitle(@Param("rankTitle") String rankTitle);

    @Query("select e from Employee e join e.position p where p.positionTitle =:positionTitle order by e.surname, e.name, e.patronymic")
    List<Employee> findByPositionTitle(@Param("positionTitle") String positionTitle);

    @Query("select e from Employee e join e.subdivision s where s.subdivisionTitle =:subdivisionTitle order by e.surname, e.name, e.patronymic")
    List<Employee> findBySubdivisionTitle(@Param("subdivisionTitle") String subdivisionTitle);

    @Query("select e from Employee e join e.position p join e.subdivision s where p = :#{#state.position} and s = :#{#state.subdivision} order by e.surname, e.name, e.patronymic")
    List<Employee> findByState(@Param("state") State state);

    @Query("select e from Employee e order by e.surname, e.name, e.patronymic")
    List<Employee> findAllOrdered();
}