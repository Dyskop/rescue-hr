package by.skopinau.rescue.dao;

import by.skopinau.rescue.model.UserEntity;

public interface UserDao {
    void save(UserEntity entity);
    UserEntity findByEmail(String email);
}
