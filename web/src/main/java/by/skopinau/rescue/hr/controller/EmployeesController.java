package by.skopinau.rescue.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Random;

@Controller
public class EmployeesController {
    @GetMapping(path = "/model")
    public String showModelPage(Model model) {
        model.addAttribute("random number", new Random().nextInt());
        return "model";
    }
}
