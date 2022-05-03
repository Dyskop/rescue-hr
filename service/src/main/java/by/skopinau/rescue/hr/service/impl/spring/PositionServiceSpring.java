package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.entity.Position;
import by.skopinau.rescue.hr.repository.PositionRepository;
import by.skopinau.rescue.hr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PositionServiceSpring extends BaseServiceSpring<Position> implements PositionService {
    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceSpring(PositionRepository positionRepository) {
        super(positionRepository);
        this.positionRepository = positionRepository;
    }

    public Position findByTitle(String positionTitle) {
        return positionRepository.findByPositionTitle(positionTitle);
    }
}