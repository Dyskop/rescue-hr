package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.State;
import by.skopinau.rescue.hr.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StateService extends BaseService<State> implements by.skopinau.rescue.hr.service.StateService {
    private final by.skopinau.rescue.hr.service.EmployeeService employeeService;
    private int actualPositionAmount;

    @Autowired
    public StateService(StateRepository stateRepository, EmployeeService employeeService) {
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