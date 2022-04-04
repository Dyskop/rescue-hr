package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.dao.hibernateImpl.EmployeeDaoImpl;
import by.skopinau.rescue.hr.model.Employee;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ViewEmployeesServlet", urlPatterns = "/view/employees")
public class ViewEmployeeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("employees", new EmployeeDaoImpl().findAll());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/viewEmployees.jsp");
        dispatcher.forward(req, resp);
    }
}
