package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.service.impl.spring.RoleServiceSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    private final RoleServiceSpring roleService;

    @Autowired
    public AdminController(RoleServiceSpring roleService) {
        this.roleService = roleService;
    }
}
