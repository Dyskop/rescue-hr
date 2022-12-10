package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.dto.EmployeeDto;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.PositionsLog;
import by.skopinau.rescue.hr.entity.RanksLog;
import by.skopinau.rescue.hr.service.EmployeeService;
import by.skopinau.rescue.hr.service.PositionsLogService;
import by.skopinau.rescue.hr.service.RanksLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static by.skopinau.rescue.hr.config.WebConfig.PAGE_SIZE;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RanksLogService rlService;

    @Autowired
    private PositionsLogService plService;

    @GetMapping
    public String showEmployees(@RequestParam(defaultValue = "1") int page, Model model) {
        List<Employee> employees = employeeService.findAllPageable(page - 1, PAGE_SIZE);
        model.addAttribute("page", page);
        model.addAttribute("employees", employees);

        return "employees";
    }

    @GetMapping("/{id}")
    public String showOneEmployee(@PathVariable("id") int id, Model model) {
        return employeeService.findById(id)
                .map(employee -> {
                    List<RanksLog> rankLogs = rlService.findByEmployee(employee);
                    List<PositionsLog> positionLogs = plService.findByEmployee(employee);

                    model.addAttribute("employee", employee);
                    model.addAttribute("rankLogs", rankLogs);
                    model.addAttribute("positionLogs", positionLogs);

                    return "view-one-employee";
                })
                .orElse("exception/view-employee-not-found");
    }

    @GetMapping("/add-form")
    public String showAddEmployeeForm() {
        return "create-employee";
    }

    @PostMapping("/add")
    public String addEmployee(EmployeeDto dto) {
        return employeeService.save(dto)
                .map(employee -> "redirect:/employees/" + employee.getId())
                .orElse("exception/view-data-not-saved");
    }

    @RequestMapping("/remove/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        if (employeeService.delete(id)) {
            return "redirect:/employees";
        }

        return "data-not-saved";
    }

    @GetMapping("/update-form/{id}")
    public String showUpdateEmployeeForm(@PathVariable("id") int id, Model model) {
        return employeeService.findById(id)
                .map(employee -> {
                    model.addAttribute("employee", employee);
                    return "update-employee";
                })
                .orElse("exception/view-employee-not-found");
    }

    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable("id") int id, EmployeeDto dto) {
        return employeeService.update(id, dto)
                .map(employee -> "redirect:/employees/" + employee.getId())
                .orElse("exception/view-data-not-saved");
    }
}
