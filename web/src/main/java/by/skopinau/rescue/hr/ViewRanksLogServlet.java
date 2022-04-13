package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.dao.hibernateImpl.EmployeeDaoImpl;
import by.skopinau.rescue.hr.dao.hibernateImpl.RanksLogDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ViewRanksLogServlet", urlPatterns = "/view/ranks-log")
public class ViewRanksLogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("logs", new RanksLogDaoImpl().findAll());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/viewRanksLog.jsp");
        dispatcher.forward(req, resp);
    }
}
