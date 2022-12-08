package by.skopinau.rescue.hr.mapper;

import by.skopinau.rescue.hr.dto.EmployeeDto;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.repository.PositionRepository;
import by.skopinau.rescue.hr.repository.RankRepository;
import by.skopinau.rescue.hr.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class EmployeeMapper {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private final RankRepository rankRepository;
    private final PositionRepository positionRepository;
    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public EmployeeMapper(RankRepository rankRepository, PositionRepository positionRepository,
                          SubdivisionRepository subdivisionRepository) {
        this.rankRepository = rankRepository;
        this.positionRepository = positionRepository;
        this.subdivisionRepository = subdivisionRepository;
    }

    public Employee mapDtoToEntity(EmployeeDto dto) {
        Employee employee = new Employee();

        employee.setSurname(dto.getSurname());
        employee.setName(dto.getName());
        employee.setPatronymic(dto.getPatronymic());
        employee.setBirthday(LocalDate.parse(dto.getBirthday(), FORMATTER));
        employee.setRank(rankRepository.findByRankTitle(dto.getRankTitle()));
        employee.setPosition(positionRepository.findByPositionTitle(dto.getPositionTitle()));
        employee.setSubdivision(subdivisionRepository.findBySubdivisionTitle(dto.getSubdivisionTitle()));

        return employee;
    }
}
