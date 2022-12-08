package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.entity.Role;
import by.skopinau.rescue.hr.repository.BaseRepository;
import by.skopinau.rescue.hr.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {
    public RoleServiceImpl(BaseRepository<Role> repository) {
        super(repository);
    }
}