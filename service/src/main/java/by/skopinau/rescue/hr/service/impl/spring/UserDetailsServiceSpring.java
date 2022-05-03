package by.skopinau.rescue.hr.service.impl.spring;

import by.skopinau.rescue.hr.entity.Role;
import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserDetailsServiceSpring extends BaseServiceSpring<User> implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceSpring(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User foundUser = userRepository.findByUsername(username);
        if (foundUser == null) {
            throw new UsernameNotFoundException("Couldn't find user by provided name!");
        }
        return new org.springframework.security.core.userdetails.User(foundUser.getUsername(),
                foundUser.getPassword(), getUserAuthorities(foundUser));
    }

    private Set<GrantedAuthority> getUserAuthorities(User user) {
        Set<Role> roles = user.getRoles();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }
}