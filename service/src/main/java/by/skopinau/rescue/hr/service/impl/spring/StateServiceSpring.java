package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.model.State;
import by.skopinau.rescue.hr.repository.StateRepository;
import by.skopinau.rescue.hr.service.EmployeeService;
import by.skopinau.rescue.hr.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StateServiceSpring extends BaseServiceSpring<State> implements StateService {
    private final EmployeeService employeeService;
    private int actualPositionAmount;

    @Autowired
    public StateServiceSpring(StateRepository stateRepository, EmployeeServiceSpring employeeService) {
        super(stateRepository);
        this.employeeService = employeeService;
    }

    public int getActualPositionAmount(State state) {
        actualPositionAmount = employeeService.findByState(state).size();
        return actualPositionAmount;
    }

    public int getFreePositionAmount(State state) {
        return state.getStateAmount() - actualPositionAmount;
    }
}