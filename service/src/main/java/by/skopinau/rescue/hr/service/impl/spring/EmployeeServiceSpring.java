package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.model.*;
import by.skopinau.rescue.hr.repository.EmployeeRepository;
import by.skopinau.rescue.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceSpring extends BaseServiceSpring<Employee> implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceSpring(EmployeeRepository employeeRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findBySurname(String surname) {
        return employeeRepository.findBySurnameOrderBySurnameAscNameAscPatronymicAsc(surname);
    }

    public List<Employee> findByName(String name) {
        return employeeRepository.findByNameOrderBySurnameAscNameAscPatronymicAsc(name);
    }

    public List<Employee> findByPatronymic(String patronymic) {
        return employeeRepository.findByPatronymicOrderBySurnameAscNameAscPatronymicAsc(patronymic);
    }

    public List<Employee> findByBirthday(LocalDate birthday) {
        return employeeRepository.findByBirthdayOrderBySurnameAscNameAscPatronymicAsc(birthday);
    }

    public List<Employee> findByRank(Rank rank) {
        return employeeRepository.findByRankOrderBySurnameAscNameAscPatronymicAsc(rank);
    }

    public List<Employee> findByPosition(Position position) {
        return employeeRepository.findByPositionOrderBySurnameAscNameAscPatronymicAsc(position);
    }

    public List<Employee> findBySubdivision(Subdivision subdivision) {
        return employeeRepository.findBySubdivisionOrderBySurnameAscNameAscPatronymicAsc(subdivision);
    }

    public List<Employee> findByRankTitle(String rankTitle) {
        return employeeRepository.findByRankTitle(rankTitle);
    }

    public List<Employee> findByPositionTitle(String positionTitle) {
        return employeeRepository.findByPositionTitle(positionTitle);
    }

    public List<Employee> findBySubdivisionTitle(String subdivisionTitle) {
        return employeeRepository.findBySubdivisionTitle(subdivisionTitle);
    }

    public List<Employee> findByState(State state) {
        return employeeRepository.findByState(state);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAllOrdered();
    }
}