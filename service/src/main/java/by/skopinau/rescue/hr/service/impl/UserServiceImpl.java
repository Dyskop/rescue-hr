package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.dto.UserDto;
import by.skopinau.rescue.hr.exception.UserExistException;
import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.model.enums.Role;
import by.skopinau.rescue.hr.repository.UserRepository;
import by.skopinau.rescue.hr.service.Pageable;
import by.skopinau.rescue.hr.service.UserService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "application")
public class UserServiceImpl extends BaseServiceImpl<User>
        implements UserService, Pageable<User> {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public Optional<User> save(UserDto dto) throws UserExistException {
        User byName = repository.findByUsername(dto.getUsername());
        if (byName != null) {
            throw new UserExistException(String.format("User with username %s already exists.",
                    dto.getUsername()));
        }
        User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setRole(Role.USER);
        repository.save(user);
        return Optional.of(user);
    }

    @Override
    @Transactional
    @CacheEvict(allEntries = true)
    public Optional<User> update(int userId, UserDto dto) {
        User user = repository.findById(userId).orElseThrow();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());

        if (dto.getAdminRole().equals("ADMIN")) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }

        return Optional.of(user);
    }

    @Override
    public List<User> findAllPageable(int page) {
        return repository.findAll(PageRequest
                .of(page, PAGE_SIZE, Sort.by("lastname", "firstname", "username"))).toList();
    }
}