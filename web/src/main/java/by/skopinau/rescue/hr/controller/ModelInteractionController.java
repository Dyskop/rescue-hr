package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.service.EmployeeService;
import by.skopinau.rescue.hr.service.PositionsLogService;
import by.skopinau.rescue.hr.service.RanksLogService;
import by.skopinau.rescue.hr.service.StateService;
import by.skopinau.rescue.hr.service.impl.spring.EmployeeServiceSpring;
import by.skopinau.rescue.hr.service.impl.spring.PositionsLogServiceSpring;
import by.skopinau.rescue.hr.service.impl.spring.RanksLogServiceSpring;
import by.skopinau.rescue.hr.service.impl.spring.StateServiceSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ModelInteractionController {
    private final EmployeeService employeeService;
    private final StateService stateService;
    private final RanksLogService ranksLogService;
    private final PositionsLogService positionsLogService;

    @Autowired
    public ModelInteractionController(EmployeeServiceSpring employeeService, StateServiceSpring stateService, RanksLogServiceSpring ranksLogService, PositionsLogServiceSpring positionsLogService) {
        this.employeeService = employeeService;
        this.stateService = stateService;
        this.ranksLogService = ranksLogService;
        this.positionsLogService = positionsLogService;
    }

    @GetMapping(path = "/view/employees")
    public String showEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "viewEmployees";
    }

    @GetMapping(path = "/view/employee/{employeeId}")
    public String showOneEmployee(@PathVariable("employeeId") int employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        model.addAttribute("rankLogs", ranksLogService.findByEmployee(employee));
        model.addAttribute("positionLogs", positionsLogService.findByEmployee(employee));
        return "viewOneEmployee";
    }

    @GetMapping(path = "/view/state")
    public String showState(Model model) {
        model.addAttribute("state", stateService.findAll());
        model.addAttribute("stateService", stateService);
        return "viewState";
    }

    @GetMapping(path = "/view/ranks-log")
    public String showRanksLog(Model model) {
        model.addAttribute("rankLogs", ranksLogService.findAll());
        return "viewRanksLog";
    }

    @GetMapping(path = "/view/positions-log")
    public String showPositionsLog(Model model) {
        model.addAttribute("positionLogs", positionsLogService.findAll());
        return "viewPositionsLog";
    }
}