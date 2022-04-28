package by.skopinau.rescue.hr.controller;

import by.skopinau.rescue.hr.impl.EmployeeServiceImpl;
import by.skopinau.rescue.hr.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ModelInteractionController {
    private final EmployeeServiceImpl employeeService;

    @Autowired
    public ModelInteractionController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/view/employees")
    public String showEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees", employees);
        return "viewEmployees";
    }

    /*
    @WebServlet(name = "ViewEmployeesServlet", urlPatterns = "/view/employees")
public class ViewEmployeesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(OrmConfig.class);
        EmployeeServiceImpl employeeService = (EmployeeServiceImpl) context.getBean("employeeServiceImpl");
        req.setAttribute("employees", employeeService.findAll());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/viewEmployees.jsp");
        dispatcher.forward(req, resp);
    }
     */
}
