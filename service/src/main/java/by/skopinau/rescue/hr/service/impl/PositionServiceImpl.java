package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.Position;
import by.skopinau.rescue.hr.repository.PositionRepository;
import by.skopinau.rescue.hr.service.PositionService;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends BaseServiceImpl<Position> implements PositionService {
    public PositionServiceImpl(PositionRepository repository) {
        super(repository);
    }
}