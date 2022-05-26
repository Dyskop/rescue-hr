package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.dto.SearchRequest;
import by.skopinau.rescue.hr.entity.Employee;
import by.skopinau.rescue.hr.entity.State;
import by.skopinau.rescue.hr.service.impl.EmployeeService;
import by.skopinau.rescue.hr.service.impl.PositionsLogService;
import by.skopinau.rescue.hr.service.impl.RanksLogService;
import by.skopinau.rescue.hr.service.impl.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    public static final int PAGE_SIZE = 10;
    private final EmployeeService employeeService;
    private final StateService stateService;
    private final RanksLogService ranksLogService;
    private final PositionsLogService positionsLogService;

    @Autowired
    public UserController(EmployeeService employeeService, StateService stateService, RanksLogService ranksLogService, PositionsLogService positionsLogService) {
        this.employeeService = employeeService;
        this.stateService = stateService;
        this.ranksLogService = ranksLogService;
        this.positionsLogService = positionsLogService;
    }

    @GetMapping("/")
    public String showIndexView() {
        return "index";
    }

    @GetMapping(path = "/view/employees/{page}")
    public String showEmployees(@PathVariable("page") int pageNumber, Model model) {
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("employees", employeeService.findAllPageable(pageNumber - 1, PAGE_SIZE));
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
    }

    @GetMapping(path = "/view/search/results/{page}")
    public String showSearchResults(@PathVariable("page") int pageNumber, Model model, SearchRequest request) {
        model.addAttribute("pageNumber", pageNumber);
        model.addAttribute("employees", employeeService.searchAllPageable(request,pageNumber - 1, PAGE_SIZE));
        return "viewEmployeesAdmin";
    }
}