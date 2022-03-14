package by.skopinau.rescue.hr.dao.impl;

import by.skopinau.rescue.hr.dao.EmployeeDao;
import by.skopinau.rescue.hr.exception.EmployeeNotFoundException;
import by.skopinau.rescue.hr.model.Employee;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoRam implements EmployeeDao {
    private final List<Employee> employees = new ArrayList<>();

    {
        employees.add(new Employee(1L, "Иванов", "Иван", "Иванович", LocalDate.of(1980, 10, 12), "Полковник", "Руководство", "Начальник отдела"));
        employees.add(new Employee(2L, "Петров", "Алексей", "Николаевич", LocalDate.of(1990, 11, 5), "Сержант", "ПАСЧ-1", "Пожарный"));
    }

    @Override
    public Employee findBySurname(String surname) throws EmployeeNotFoundException {
        return employees.stream()
                .filter(employee -> employee.getSurname().equals(surname))
                .findFirst()
                .orElseThrow(
                        () -> new EmployeeNotFoundException("Employee not found")
                );
    }
}
