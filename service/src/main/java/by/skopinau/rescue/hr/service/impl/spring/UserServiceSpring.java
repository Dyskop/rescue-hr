package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.dto.UpdateUserRequest;
import by.skopinau.rescue.hr.entity.Role;
import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.repository.RoleRepository;
import by.skopinau.rescue.hr.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserServiceSpring extends BaseServiceSpring<User> {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceSpring(UserRepository userRepository, RoleRepository roleRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public List<User> findAllPageable(int page, int size) {
        return userRepository.findAllOrdered(PageRequest.of(page, size));
    }

    public List<String> getRolesNames(User user) {
        List<String> rolesNames = new ArrayList<>();
        for (Role role : user.getRoles()) {
            rolesNames.add(role.getName());
        }
        return rolesNames;
    }

    public void updateUser(int userId, UpdateUserRequest updateUserRequest) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setFirstname(updateUserRequest.getFirstname());
        user.setLastname(updateUserRequest.getLastname());
        user.setEmail(updateUserRequest.getEmail());
        user.setUsername(updateUserRequest.getUsername());

        Set<Role> roles = new HashSet<>();
        if (updateUserRequest.getAdminRole().equals("ADMIN")) {
            roles.add(roleRepository.findByName("ADMIN"));
        } else roles.add(roleRepository.findByName("USER"));
        user.setRoles(roles);
    }
}