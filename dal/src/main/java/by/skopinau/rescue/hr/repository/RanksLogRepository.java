package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.RanksLog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RanksLogRepository extends BaseRepository<RanksLog> {
    List<RanksLog> findByEmployeeOrderByRankGettingDateDesc(Employee employee);

    @Query("select rl from RanksLog rl " +
            "join rl.employee e " +
            "order by rl.rankGettingDate desc, " +
            "e.surname asc, e.name asc, e.patronymic asc")
    List<RanksLog> findAllOrdered();

    @Query("select rl from RanksLog rl " +
            "join rl.employee e " +
            "order by rl.rankGettingDate desc, " +
            "e.surname asc, e.name asc, e.patronymic asc")
    List<RanksLog> findAllOrdered(Pageable pageable);
}