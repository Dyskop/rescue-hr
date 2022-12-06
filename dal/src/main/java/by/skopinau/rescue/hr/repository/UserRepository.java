package by.skopinau.rescue.hr.repository;

import by.skopinau.rescue.hr.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends BaseRepository<User> {
    User findByUsername(String username);

    @Query("select u from User u " +
            "order by u.id")
    List<User> findAllOrdered(Pageable pageable);
}