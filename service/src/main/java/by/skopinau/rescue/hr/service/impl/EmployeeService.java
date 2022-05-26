package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.dto.CreateEmployeeRequest;
import by.skopinau.rescue.hr.dto.SearchRequest;
import by.skopinau.rescue.hr.entity.*;
import by.skopinau.rescue.hr.repository.EmployeeRepository;
import by.skopinau.rescue.hr.repository.PositionRepository;
import by.skopinau.rescue.hr.repository.RankRepository;
import by.skopinau.rescue.hr.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class EmployeeService extends BaseService<Employee> implements by.skopinau.rescue.hr.service.EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final RankRepository rankRepository;
    private final PositionRepository positionRepository;
    private final SubdivisionRepository subdivisionRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RankRepository rankRepository, PositionRepository positionRepository, SubdivisionRepository subdivisionRepository) {
        super(employeeRepository);
        this.employeeRepository = employeeRepository;
        this.rankRepository = rankRepository;
        this.positionRepository = positionRepository;
        this.subdivisionRepository = subdivisionRepository;
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

    public List<Employee> findAllPageable(int page, int size) {
        return employeeRepository.findAllOrdered(PageRequest.of(page, size));
    }

    public List<Employee> searchAllPageable(SearchRequest searchRequest, int page, int size) {
        return employeeRepository.searchAllOrdered(searchRequest.getData(), PageRequest.of(page, size));
    }


    public void createEmployee(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = new Employee();
        saveEmployee(createEmployeeRequest, employee);
    }

    public void updateEmployee(int employeeId, CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow();
        saveEmployee(createEmployeeRequest, employee);
    }

    private void saveEmployee(CreateEmployeeRequest createEmployeeRequest, Employee employee) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        employee.setSurname(createEmployeeRequest.getSurname());
        employee.setName(createEmployeeRequest.getName());
        employee.setPatronymic(createEmployeeRequest.getPatronymic());
        employee.setBirthday(LocalDate.parse(createEmployeeRequest.getBirthday(), formatter));
        employee.setRank(rankRepository.findByRankTitle(createEmployeeRequest.getRankTitle()));
        employee.setPosition(positionRepository.findByPositionTitle(createEmployeeRequest.getPositionTitle()));
        employee.setSubdivision(subdivisionRepository.findBySubdivisionTitle(createEmployeeRequest.getSubdivisionTitle()));
        employeeRepository.save(employee);
    }
}