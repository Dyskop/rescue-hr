package by.skopinau.rescue.hr.mapper;

import by.skopinau.rescue.hr.dto.RanksLogDto;
import by.skopinau.rescue.hr.entity.RanksLog;
import by.skopinau.rescue.hr.repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class RanksLogMapper {
    // duplicated
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final RankRepository rankRepository;

    @Autowired
    public RanksLogMapper(RankRepository rankRepository) {
        this.rankRepository = rankRepository;
    }

    public RanksLog mapDtoToEntity(RanksLogDto dto) {
        RanksLog ranksLog = new RanksLog();

        ranksLog.setGettingDate(LocalDate.parse(dto.getGettingDate(), FORMATTER));
        ranksLog.setEmployee(dto.getEmployee());
        ranksLog.setRank(rankRepository.findByRankTitle(dto.getRankTitle()));
        ranksLog.setOrderPublisher(dto.getRankOrderPublisher());
        ranksLog.setOrderNumber(Integer.parseInt(dto.getRankOrderNumber()));
        return ranksLog;
    }
}
