package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.dto.UserDto;
import by.skopinau.rescue.hr.exception.UserExistException;
import by.skopinau.rescue.hr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationView(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerNewUser(UserDto userDto) throws UserExistException {
        userService.save(userDto);
        return "redirect:login";
    }
}