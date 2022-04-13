package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.dao.hibernateImpl.PositionsLogDaoImpl;
import by.skopinau.rescue.hr.dao.hibernateImpl.RanksLogDaoImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ViewPositionsLogServlet", urlPatterns = "/view/positions-log")
public class ViewPositionsLogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("logs", new PositionsLogDaoImpl().findAll());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/viewPositionsLog.jsp");
        dispatcher.forward(req, resp);
    }
}