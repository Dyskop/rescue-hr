package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.config.Config;
import by.skopinau.rescue.hr.impl.PositionsLogServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "ViewPositionsLogServlet", urlPatterns = "/view/positions-log")
public class ViewPositionsLogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PositionsLogServiceImpl positionsLogService = (PositionsLogServiceImpl) context.getBean("positionsLogServiceImpl");
        req.setAttribute("logs", positionsLogService.findAll());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/viewPositionsLog.jsp");
        dispatcher.forward(req, resp);
    }
}