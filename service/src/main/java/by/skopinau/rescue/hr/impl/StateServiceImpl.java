package by.skopinau.rescue.hr.impl;

import by.skopinau.rescue.hr.dao.impl.EmployeeDaoImpl;
import by.skopinau.rescue.hr.dao.impl.StateDaoImpl;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl extends BaseServiceImpl<State> {
    private int actualPositionAmount;
    private final List<Employee> employees;

    @Autowired
    public StateServiceImpl(StateDaoImpl stateDao, EmployeeDaoImpl employeeDao) {
        super(stateDao);
        this.employees = employeeDao.findAll();
    }

    public int getActualPositionAmount(State state) {
        actualPositionAmount = (int) employees.stream()
                .filter(employee -> employee.getPosition().equals(state.getPosition()))
                .filter(employee -> employee.getSubdivision().equals(state.getSubdivision()))
                .count();
        return actualPositionAmount;
    }

    public int getFreePositionAmount(State state) {
        return state.getStateAmount() - actualPositionAmount;
    }
}