package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.dto.CreateEmployeeRequest;
import by.skopinau.rescue.hr.entity.Role;
import by.skopinau.rescue.hr.entity.User;
import by.skopinau.rescue.hr.service.StateService;
import by.skopinau.rescue.hr.service.impl.spring.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class AdminController {
    public static final int PAGE_SIZE = 10;
    private final EmployeeServiceSpring employeeService;
    private final StateService stateService;
    private final RanksLogServiceSpring ranksLogService;
    private final PositionsLogServiceSpring positionsLogService;
    private final RankServiceSpring rankService;
    private final PositionServiceSpring positionService;
    private final SubdivisionServiceSpring subdivisionService;
    private final UserDetailsServiceSpring userDetailsService;

    @Autowired
    public AdminController(EmployeeServiceSpring employeeService, StateServiceSpring stateService, RanksLogServiceSpring ranksLogService, PositionsLogServiceSpring positionsLogService, RankServiceSpring rankService, PositionServiceSpring positionService, SubdivisionServiceSpring subdivisionService, UserDetailsServiceSpring userDetailsService) {
        this.employeeService = employeeService;
        this.stateService = stateService;
        this.ranksLogService = ranksLogService;
        this.positionsLogService = positionsLogService;
        this.rankService = rankService;
        this.positionService = positionService;
        this.subdivisionService = subdivisionService;
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/admin")
    public String showIndexView() {
        return "admin";
    }

    @GetMapping(path = "/admin/employees/{page}")
    public String showEmployees(@PathVariable("page") int pageNumber, Model model) {
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("employees", employeeService.findAllPageable(pageNumber - 1, PAGE_SIZE));
        return "viewEmployeesAdmin";
    }

    @GetMapping("/admin/employees/create")
    public String showCreateEmployeeView(Model model) {
        return "createEmployee";
    }

    @PostMapping("/admin/employees/create")
    public String createNewEmployee(CreateEmployeeRequest createEmployeeRequest) {
/*        List<Rank> ranks = rankService.findAll();
        List<Position> positions = positionService.findAll();
        List<Subdivision> subdivisions = subdivisionService.findAll();
        model.addAttribute("ranks", ranks);
        model.addAttribute("positions", positions);
        model.addAttribute("subdivisions", subdivisions);*/
        employeeService.createEmployee(createEmployeeRequest);
        return "redirect:1";
    }

    @GetMapping(path = "/admin/users/{page}")
    public String showUsers(@PathVariable("page") int pageNumber, Model model) {
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("users", userDetailsService.findAllPageable(pageNumber - 1, PAGE_SIZE));
        return "viewUsersAdmin";
    }

    /*@GetMapping(path = "/view/employee/{employeeId}")
    public String showOneEmployee(@PathVariable("employeeId") int employeeId, Model model) {
        Employee employee = employeeService.findById(employeeId);
        model.addAttribute("employee", employee);
        model.addAttribute("rankLogs", ranksLogService.findByEmployee(employee));
        model.addAttribute("positionLogs", positionsLogService.findByEmployee(employee));
        return "viewOneEmployee";
    }

    @GetMapping(path = "/view/state")
    public String showState(Model model) {
        List<State> list = stateService.findAll();
        Map<State, Integer> mapWithActualPositionsAmounts = new HashMap<>();
        Map<State, Integer> mapWithFreePositionsAmounts = new HashMap<>();
        for (State state: list) {
            mapWithActualPositionsAmounts.put(state, stateService.getActualPositionAmount(state));
            mapWithFreePositionsAmounts.put(state, stateService.getFreePositionAmount(state));
        }
        model.addAttribute("stateList", list);
        model.addAttribute("actualAmounts", mapWithActualPositionsAmounts);
        model.addAttribute("freeAmounts", mapWithFreePositionsAmounts);
        return "viewState";
    }

    @GetMapping(path = "/view/ranks-log/{page}")
    public String showRanksLog(@PathVariable("page") int pageNumber, Model model) {
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("rankLogs", ranksLogService.findAllPageable(pageNumber - 1, PAGE_SIZE));
        return "viewRanksLog";
    }

    @GetMapping(path = "/view/positions-log/{page}")
    public String showPositionsLog(@PathVariable("page") int pageNumber, Model model) {
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("positionLogs", positionsLogService.findAllPageable(pageNumber - 1, PAGE_SIZE));
        return "viewPositionsLog";
    }*/
}
