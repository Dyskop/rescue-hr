package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.dto.UserDto;
import by.skopinau.rescue.hr.exception.UserExistException;
import by.skopinau.rescue.hr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(UserDto dto) throws UserExistException {
        // todo: handle exception
        userService.save(dto);
        return "login";
    }
}