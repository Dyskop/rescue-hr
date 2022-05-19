package by.skopinau.rescue.hr.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
public class UpdateUserRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String adminRole;
}