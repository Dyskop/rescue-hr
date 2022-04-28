package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.config.Config;
import by.skopinau.rescue.hr.model.Employee;
import by.skopinau.rescue.hr.impl.EmployeeServiceImpl;
import by.skopinau.rescue.hr.impl.PositionsLogServiceImpl;
import by.skopinau.rescue.hr.impl.RanksLogServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "ViewOneEmployeeServlet", urlPatterns = "/view/employee/*")
public class ViewOneEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] split = req.getRequestURI().split("[^0-9]*");
        StringBuilder builder = new StringBuilder();
        for (String s : split) {
            builder.append(s);
        }
        int employeeId = Integer.parseInt(builder.toString());

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        EmployeeServiceImpl employeeService = (EmployeeServiceImpl) context.getBean("employeeServiceImpl");
        PositionsLogServiceImpl positionsLogService = (PositionsLogServiceImpl) context.getBean("positionsLogServiceImpl");
        RanksLogServiceImpl ranksLogService = (RanksLogServiceImpl) context.getBean("ranksLogServiceImpl");

        Employee employee = employeeService.findById(employeeId);
        req.setAttribute("employee", employee);
        req.setAttribute("positionLogs", positionsLogService.findByEmployee(employee));
        req.setAttribute("rankLogs", ranksLogService.findByEmployee(employee));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/viewOneEmployee.jsp");
        dispatcher.forward(req, resp);
    }
}