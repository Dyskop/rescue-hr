package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.dto.EmployeeDto;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.PositionLog;
import by.skopinau.rescue.hr.entity.RankLog;
import by.skopinau.rescue.hr.service.EmployeeService;
import by.skopinau.rescue.hr.service.PositionLogService;
import by.skopinau.rescue.hr.service.RankLogService;
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
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService eService;

    @Autowired
    private RankLogService rlService;

    @Autowired
    private PositionLogService plService;

    @GetMapping
    public String showEmployees(@RequestParam(defaultValue = "1") int page, Model model) {
        List<Employee> employees = eService.findAllPageable(page - 1);
        boolean pagination = eService.showPagination();
        int total = eService.getTotalPages();

        model.addAttribute("page", page);
        model.addAttribute("employees", employees);
        model.addAttribute("pagination", pagination);
        model.addAttribute("view", "employees");
        model.addAttribute("total", total);

        return "employees";
    }

    @GetMapping("/{id}")
    public String showOneEmployee(@PathVariable("id") int id, Model model) {
        return eService.findById(id)
                .map(employee -> {
                    List<RankLog> rankLogs = rlService.findByEmployee(employee);
                    List<PositionLog> positionLogs = plService.findByEmployee(employee);

                    model.addAttribute("employee", employee);
                    model.addAttribute("rankLogs", rankLogs);
                    model.addAttribute("positionLogs", positionLogs);

                    return "one-employee";
                })
                .orElse("exception/employee-not-found");
    }

    @GetMapping("/add-form")
    public String showAddEmployeeForm() {
        return "create-employee";
    }

    @PostMapping("/add")
    public String addEmployee(EmployeeDto dto) {
        return eService.save(dto)
                .map(employee -> "redirect:/employees/" + employee.getId())
                .orElse("exception/data-not-saved");
    }

    @RequestMapping("/remove/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        if (eService.delete(id)) {
            return "redirect:/employees";
        }

        return "exception/data-not-saved";
    }

    @GetMapping("/update-form/{id}")
    public String showUpdateEmployeeForm(@PathVariable("id") int id, Model model) {
        return eService.findById(id)
                .map(employee -> {
                    model.addAttribute("employee", employee);
                    return "update-employee";
                })
                .orElse("exception/employee-not-found");
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") int id, EmployeeDto dto) {
        return eService.update(id, dto)
                .map(employee -> "redirect:/employees/" + employee.getId())
                .orElse("exception/data-not-saved");
    }
}
