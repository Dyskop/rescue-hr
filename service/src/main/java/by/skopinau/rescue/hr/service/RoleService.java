package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.entity.Role;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

public interface RoleService extends BaseService<Role> {
    List<String> getRoles(Collection<? extends GrantedAuthority> grantedAuthorities);
}