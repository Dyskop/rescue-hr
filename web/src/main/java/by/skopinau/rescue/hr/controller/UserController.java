package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.dto.UserDto;
import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String showUsers(@RequestParam(defaultValue = "1") int page, Model model) {
        List<User> users = userService.findAllPageable(page - 1);
        boolean pagination = userService.showPagination();
        int total = userService.getTotalPages();

        model.addAttribute("page", page);
        model.addAttribute("users", users);
        model.addAttribute("pagination", pagination);
        model.addAttribute("view", "users");
        model.addAttribute("total", total);

        return "users";
    }

    @RequestMapping("/remove/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        if (userService.delete(id)) {
            return "redirect:/users";
        }

        return "exception/data-not-saved";
    }

    @GetMapping("/update-form/{id}")
    public String showUpdateUserForm(@PathVariable("id") int id, Model model) {
        return userService.findById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    return "update-user";
                })
                .orElse("exception/view-user-not-found");
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, UserDto dto) {
        return userService.update(id, dto)
                .map(user -> "redirect:/users")
                .orElse("exception/view-data-not-saved");
    }
}
