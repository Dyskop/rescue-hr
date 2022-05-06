package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.dto.UserRegistrationRequest;
import by.skopinau.rescue.hr.exception.UserExistException;
import by.skopinau.rescue.hr.service.impl.spring.AccountServiceSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final AccountServiceSpring accountService;

    @Autowired
    public AuthController(AccountServiceSpring accountService) {
        this.accountService = accountService;
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
    public String registerNewUser(UserRegistrationRequest userRegistrationRequest) throws UserExistException {
        accountService.createUser(userRegistrationRequest);
        return "redirect:login";
    }
}