package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.dto.UserDto;
import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.exception.UserExistException;

import java.util.Optional;

public interface UserService extends BaseService<User>, Pageable<User> {
    Optional<User> save(UserDto dto) throws UserExistException;

    Optional<User> update(int id, UserDto dto);
}