package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.dao.hibernateImpl.EmployeeDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
        req.setAttribute("employee", new EmployeeDaoImpl().findById(employeeId));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/viewOneEmployee.jsp");
        dispatcher.forward(req, resp);
    }
}
