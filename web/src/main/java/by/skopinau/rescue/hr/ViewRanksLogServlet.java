package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.config.Config;
import by.skopinau.rescue.hr.impl.RanksLogServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "ViewRanksLogServlet", urlPatterns = "/view/ranks-log")
public class ViewRanksLogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        RanksLogServiceImpl ranksLogService = (RanksLogServiceImpl) context.getBean("ranksLogServiceImpl");
        req.setAttribute("logs", ranksLogService.findAll());
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/viewRanksLog.jsp");
        dispatcher.forward(req, resp);
    }
}