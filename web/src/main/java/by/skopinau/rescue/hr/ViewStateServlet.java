package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.dao.hibernateImpl.EmployeeDaoImpl;
import by.skopinau.rescue.hr.dao.hibernateImpl.PositionsLogDaoImpl;
import by.skopinau.rescue.hr.dao.hibernateImpl.StateDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ViewStateServlet", urlPatterns = "/view/state")
public class ViewStateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("state", new StateDaoImpl().findAll());
        req.setAttribute("stateService", new StateService());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/viewState.jsp");
        dispatcher.forward(req, resp);
    }
}