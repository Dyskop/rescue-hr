package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.impl.EmployeeServiceImpl;
import by.skopinau.rescue.hr.impl.PositionsLogServiceImpl;
import by.skopinau.rescue.hr.impl.RanksLogServiceImpl;
import by.skopinau.rescue.hr.impl.StateServiceImpl;
import by.skopinau.rescue.hr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ModelInteractionController {
    private final EmployeeServiceImpl employeeService;
    private final StateServiceImpl stateService;
    private final RanksLogServiceImpl ranksLogService;
    private final PositionsLogServiceImpl positionsLogService;

    @Autowired
    public ModelInteractionController(EmployeeServiceImpl employeeService, StateServiceImpl stateService, RanksLogServiceImpl ranksLogService, PositionsLogServiceImpl positionsLogService) {
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