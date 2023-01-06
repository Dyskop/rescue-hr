package by.skopinau.rescue.hr.mapper;

import by.skopinau.rescue.hr.dto.EmployeeDto;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.model.enums.Rank;
import by.skopinau.rescue.hr.repository.PositionRepository;
import by.skopinau.rescue.hr.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

import static org.hibernate.type.LocalDateType.FORMATTER;

@Component
public class EmployeeMapper {
    private final PositionRepository positionRepository;
    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public EmployeeMapper(PositionRepository positionRepository,
                          SubdivisionRepository subdivisionRepository) {
        this.positionRepository = positionRepository;
        this.subdivisionRepository = subdivisionRepository;
    }

    public Employee mapDtoToEntity(EmployeeDto dto) {
        Employee employee = new Employee();

        employee.setSurname(dto.getSurname());
        employee.setName(dto.getName());
        employee.setPatronymic(dto.getPatronymic());
        employee.setBirthday(LocalDate.parse(dto.getBirthday(), FORMATTER));
        employee.setRank(Rank.of(dto.getRankTitle()));
        employee.setPosition(positionRepository.findByPositionTitle(dto.getPositionTitle()));
        employee.setSubdivision(subdivisionRepository.findBySubdivisionTitle(dto.getSubdivisionTitle()));

        return employee;
    }
}
