package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.model.Position;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends BaseRepository<Position> {
    Position findByPositionTitle(String positionTitle);
}