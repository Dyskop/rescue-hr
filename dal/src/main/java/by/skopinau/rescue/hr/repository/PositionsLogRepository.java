package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.PositionsLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionsLogRepository extends BaseRepository<PositionsLog> {
    List<PositionsLog> findByEmployeeOrderByPositionGettingDateDesc(Employee employee);

    @Query("select pl from PositionsLog pl " +
            "join pl.employee e " +
            "order by pl.positionGettingDate desc, " +
            "e.surname asc, e.name asc, e.patronymic asc")
    List<PositionsLog> findAllOrdered();

    @Query("select pl from PositionsLog pl " +
            "join pl.employee e " +
            "order by pl.positionGettingDate desc, " +
            "e.surname asc, e.name asc, e.patronymic asc")
    List<PositionsLog> findAllOrdered(Pageable pageable);
}