package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.Position;
import by.skopinau.rescue.hr.repository.BaseRepository;
import by.skopinau.rescue.hr.service.PositionService;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl extends BaseServiceImpl<Position> implements PositionService {
    public PositionServiceImpl(BaseRepository<Position> repository) {
        super(repository);
    }
}