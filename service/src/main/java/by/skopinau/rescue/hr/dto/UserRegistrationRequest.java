package by.skopinau.rescue.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserRegistrationRequest {
    private String username;
    private String password;
}