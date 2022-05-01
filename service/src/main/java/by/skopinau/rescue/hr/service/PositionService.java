package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.model.Position;

public interface PositionService extends BaseService<Position> {
    Position findByTitle(String positionTitle);
}