package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.dao.hibernateImpl.EmployeeDaoImpl;
import by.skopinau.rescue.hr.dao.hibernateImpl.StateDaoImpl;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.State;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StateService {
    private int actualPositionAmount;
    private int freePositionAmount;
    private List<Employee> employees = new EmployeeDaoImpl().findAll();
    private List<State> states = new StateDaoImpl().findAll();

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