package by.skopinau.rescue.hr.mapper;

import by.skopinau.rescue.hr.dto.RankLogDto;
import by.skopinau.rescue.hr.entity.RankLog;
import by.skopinau.rescue.hr.model.enums.Rank;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.hibernate.type.LocalDateType.FORMATTER;

@Component
public class RankLogMapper {
    public RankLog mapDtoToEntity(RankLogDto dto) {
        RankLog rankLog = new RankLog();

        rankLog.setGettingDate(LocalDate.parse(dto.getGettingDate(), FORMATTER));
        rankLog.setEmployee(dto.getEmployee());
        rankLog.setRank(Rank.of(dto.getRankTitle()));
        rankLog.setOrderPublisher(dto.getRankOrderPublisher());
        rankLog.setOrderNumber(Integer.parseInt(dto.getRankOrderNumber()));
        return rankLog;
    }
}
