package by.skopinau.rescue.hr.service;

import by.skopinau.rescue.hr.dto.UpdateUserRequest;
import by.skopinau.rescue.hr.entity.User;

import java.util.List;

public interface UserService extends BaseService<User> {
    List<User> findAllPageable(int page, int size);

    List<String> getRolesNames(User user);

    void updateUser(int userId, UpdateUserRequest updateUserRequest);
}