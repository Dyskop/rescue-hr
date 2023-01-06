package by.skopinau.rescue.hr.mapper;

import by.skopinau.rescue.hr.dto.RanksLogDto;
import by.skopinau.rescue.hr.entity.RanksLog;
import by.skopinau.rescue.hr.model.enums.Rank;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.hibernate.type.LocalDateType.FORMATTER;

@Component
public class RanksLogMapper {
    public RanksLog mapDtoToEntity(RanksLogDto dto) {
        RanksLog ranksLog = new RanksLog();

        ranksLog.setGettingDate(LocalDate.parse(dto.getGettingDate(), FORMATTER));
        ranksLog.setEmployee(dto.getEmployee());
        ranksLog.setRank(Rank.of(dto.getRankTitle()));
        ranksLog.setOrderPublisher(dto.getRankOrderPublisher());
        ranksLog.setOrderNumber(Integer.parseInt(dto.getRankOrderNumber()));
        return ranksLog;
    }
}
