package by.skopinau.rescue.hr.service.impl;

import by.skopinau.rescue.hr.dto.UserDto;
import by.skopinau.rescue.hr.entity.Role;
import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.exception.UserExistException;
import by.skopinau.rescue.hr.repository.RoleRepository;
import by.skopinau.rescue.hr.repository.UserRepository;
import by.skopinau.rescue.hr.service.Pageable;
import by.skopinau.rescue.hr.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl extends BaseServiceImpl<User>
        implements UserService, Pageable<User> {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        super(userRepository);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Optional<User> save(UserDto dto) throws UserExistException {
        User byName = userRepository.findByUsername(dto.getUsername());
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
        user.setRoles(Set.of(roleRepository.getById(2)));
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    @Transactional
    public Optional<User> update(int userId, UserDto userDto) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setEmail(userDto.getEmail());
        user.setUsername(userDto.getUsername());

        Set<Role> roles = new HashSet<>();
        if (userDto.getAdminRole().equals("ADMIN")) {
            roles.add(roleRepository.findByName("ADMIN"));
        } else roles.add(roleRepository.findByName("USER"));
        user.setRoles(roles);
        return Optional.of(user);
    }

    @Override
    public List<String> getRolesNames(User user) {
        List<String> rolesNames = new ArrayList<>();
        for (Role role : user.getRoles()) {
            rolesNames.add(role.getName());
        }
        return rolesNames;
    }

    @Override
    public List<User> findAllPageable(int page, int size) {
        return userRepository.findAll(PageRequest
                .of(page, size, Sort.by("lastname", "firstname", "username"))).toList();
    }
}