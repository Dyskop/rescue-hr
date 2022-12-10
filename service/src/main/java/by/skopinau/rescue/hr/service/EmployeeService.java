package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.dto.EmployeeDto;
import by.skopinau.rescue.hr.dto.SearchDto;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.State;

import java.util.List;
import java.util.Optional;

public interface EmployeeService extends BaseService<Employee>, Pageable<Employee> {
    Optional<Employee> save(EmployeeDto dto);

    Optional<Employee> update(int id, EmployeeDto dto);

    List<Employee> findByState(State state);

    List<Employee> search(SearchDto searchDto, int page, int size);
}