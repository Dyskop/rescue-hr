package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.dto.CreateRanksLogRequest;
import by.skopinau.rescue.hr.entity.*;
import by.skopinau.rescue.hr.repository.RankRepository;
import by.skopinau.rescue.hr.repository.RanksLogRepository;
import by.skopinau.rescue.hr.service.RanksLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class RanksLogServiceSpring extends BaseServiceSpring<RanksLog> implements RanksLogService {
    private final RanksLogRepository ranksLogRepository;
    private final RankRepository rankRepository;

    @Autowired
    public RanksLogServiceSpring(RanksLogRepository ranksLogRepository, RankRepository rankRepository) {
        super(ranksLogRepository);
        this.ranksLogRepository = ranksLogRepository;
        this.rankRepository = rankRepository;
    }

    public List<RanksLog> findByEmployee(Employee employee) {
        return ranksLogRepository.findByEmployeeOrderByRankGettingDateDesc(employee);
    }

    @Override
    public List<RanksLog> findAll() {
        return ranksLogRepository.findAllOrdered();
    }

    public List<RanksLog> findAllPageable(int page, int size) {
        return ranksLogRepository.findAllOrdered(PageRequest.of(page, size));
    }

    public void createRanksLog(CreateRanksLogRequest createRanksLogRequest) {
        RanksLog ranksLog = new RanksLog();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ranksLog.setRankGettingDate(LocalDate.parse(createRanksLogRequest.getRankGettingDate(), formatter));
        ranksLog.setEmployee(createRanksLogRequest.getEmployee());
        ranksLog.setRank(rankRepository.findByRankTitle(createRanksLogRequest.getRankTitle()));
        ranksLog.setOrderPublisher(createRanksLogRequest.getRankOrderPublisher());
        ranksLog.setOrderNumber(Integer.parseInt(createRanksLogRequest.getRankOrderNumber()));
        ranksLogRepository.save(ranksLog);
    }
}