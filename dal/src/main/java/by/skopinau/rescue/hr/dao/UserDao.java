package by.skopinau.rescue.hr.dao;

import by.skopinau.rescue.hr.model.UserEntity;

public interface UserDao {
    void save(UserEntity entity);
    UserEntity findByEmail(String email);
}
