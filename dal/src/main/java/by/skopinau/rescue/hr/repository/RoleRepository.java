package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends BaseRepository<Role> {
    Role findByName(String roleName);
}