package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.Position;
import by.skopinau.rescue.hr.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PositionService extends BaseService<Position> implements by.skopinau.rescue.hr.service.PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionService(PositionRepository positionRepository) {
        super(positionRepository);
        this.positionRepository = positionRepository;
    }

    public Position findByTitle(String positionTitle) {
        return positionRepository.findByPositionTitle(positionTitle);
    }
}