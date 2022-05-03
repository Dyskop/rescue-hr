package by.skopinau.rescue.hr.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @JoinTable(name = "users_roles_link",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany
    private Set<Role> roles = new HashSet<>();
}