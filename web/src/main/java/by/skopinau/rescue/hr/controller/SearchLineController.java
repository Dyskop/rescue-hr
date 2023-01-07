package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.dto.SearchDto;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchLineController {
    @Autowired
    EmployeeService eService;

    @GetMapping("/search")
    public String showSearchResults(@RequestParam(defaultValue = "1") int page,
                                    Model model, SearchDto dto) {
        List<Employee> employees = eService.searchAllPageable(dto, page - 1);
        boolean pagination = eService.showPagination(dto);
        int total = eService.getTotalPages(); // todo: override

        model.addAttribute("page", page);
        model.addAttribute("employees", employees);
        model.addAttribute("pagination", pagination);
        model.addAttribute("data", dto.getData());
        model.addAttribute("view", "search-line");
        model.addAttribute("total", total);

        return "search-line";
    }
}
