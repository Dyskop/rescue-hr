package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User> {
    User findByUsername(String username);
}