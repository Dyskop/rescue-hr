package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.State;
import by.skopinau.rescue.hr.repository.StateRepository;
import by.skopinau.rescue.hr.service.EmployeeService;
import by.skopinau.rescue.hr.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl extends BaseServiceImpl<State> implements StateService {
    private final EmployeeService employeeService;
    private int actualPositionAmount;

    @Autowired
    public StateServiceImpl(StateRepository stateRepository, EmployeeServiceImpl employeeService) {
        super(stateRepository);
        this.employeeService = employeeService;
    }
    // todo: caching
    public int getActualPositionAmount(State state) {
        actualPositionAmount = employeeService.findByState(state).size();
        return actualPositionAmount;
    }

    public int getFreePositionAmount(State state) {
        return state.getStateAmount() - actualPositionAmount;
    }
}