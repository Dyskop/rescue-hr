package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.dto.EmployeeDto;
import by.skopinau.rescue.hr.dto.SearchDto;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.State;
import by.skopinau.rescue.hr.mapper.EmployeeMapper;
import by.skopinau.rescue.hr.repository.EmployeeRepository;
import by.skopinau.rescue.hr.service.EmployeeService;
import by.skopinau.rescue.hr.service.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl extends BaseServiceImpl<Employee>
        implements EmployeeService, Pageable<Employee> {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public Optional<Employee> save(EmployeeDto dto) {
        Employee employee = mapper.mapDtoToEntity(dto);
        return Optional.of(repository.save(employee));
    }

    @Override
    @Transactional
    public Optional<Employee> update(int id, EmployeeDto dto) {
        if (repository.existsById(id)) {
            Employee employee = mapper.mapDtoToEntity(dto);
            employee.setId(id);
            return save(employee);
        }

        return Optional.empty();
    }

    @Override
    public List<Employee> findByState(State state) {
        return repository.findByState(state);
    }

    @Override
    public List<Employee> findAllPageable(int page) {
        return repository.findAll(PageRequest
                .of(page, PAGE_SIZE, Sort.by("surname", "name", "patronymic"))).toList();
    }

    @Override
    public List<Employee> searchAllPageable(SearchDto dto, int page) {
        return repository.searchAllPageable(dto.getData(), PageRequest.of(page, PAGE_SIZE));
    }

    private List<Employee> searchAll(SearchDto dto) {
        return repository.searchAll(dto.getData());
    }

    public boolean showPagination(SearchDto dto) {
        return searchAll(dto).size() > PAGE_SIZE;
    }
}