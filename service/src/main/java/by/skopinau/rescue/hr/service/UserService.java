package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.dto.UserDto;
import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.exception.UserExistException;

import java.util.List;
import java.util.Optional;

public interface UserService extends BaseService<User>, Pageable<User> {
    Optional<User> save(UserDto dto) throws UserExistException;

    Optional<User> update(int id, UserDto dto);

    // todo: change to getGrantedAuthorities method in UserDetailsService
    List<String> getRolesNames(User user);
}