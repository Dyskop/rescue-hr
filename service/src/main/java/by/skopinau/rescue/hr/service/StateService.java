package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.entity.State;

public interface StateService extends BaseService<State> {
    int getActualPositionAmount(State state);

    int getFreePositionAmount(State state);
}