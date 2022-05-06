package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.dto.UserRegistrationRequest;
import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.exception.UserExistException;
import by.skopinau.rescue.hr.repository.RoleRepository;
import by.skopinau.rescue.hr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class AccountServiceSpring {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AccountServiceSpring(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserRegistrationRequest userRegistrationRequest) throws UserExistException {
        User byName = userRepository.findByUsername(userRegistrationRequest.getUsername());
        if (byName != null) {
            throw new UserExistException(String.format("User with username %s already exists.", userRegistrationRequest.getUsername()));
        }
        User user = new User();
        user.setFirstname(userRegistrationRequest.getFirstname());
        user.setLastname(userRegistrationRequest.getLastname());
        user.setEmail(userRegistrationRequest.getEmail());
        user.setUsername(userRegistrationRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
        user.setRoles(Set.of(roleRepository.getById(2)));
        userRepository.save(user);
    }
}