package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.model.State;
import by.skopinau.rescue.hr.repository.StateRepository;
import by.skopinau.rescue.hr.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StateServiceSpring extends BaseServiceSpring<State> implements StateService {
    private int actualPositionAmount;
    private final List<Employee> employees;

    @Autowired
    public StateServiceSpring(StateRepository stateRepository, List<Employee> employees) {
        super(stateRepository);
        this.employees = employees;
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