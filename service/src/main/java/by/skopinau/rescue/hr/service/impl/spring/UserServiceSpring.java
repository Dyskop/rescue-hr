package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceSpring extends BaseServiceSpring<User> {
    private final UserRepository userRepository;

    public UserServiceSpring(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public List<User> findAllPageable(int page, int size) {
        return userRepository.findAllOrdered(PageRequest.of(page, size));
    }
}