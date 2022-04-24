package by.skopinau.rescue.hr;

import by.skopinau.rescue.hr.impl.StateServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@WebServlet(name = "ViewStateServlet", urlPatterns = "/view/state")
public class ViewStateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        StateServiceImpl stateService = (StateServiceImpl) context.getBean("stateServiceImpl");
        req.setAttribute("state", stateService.findAll());
        req.setAttribute("stateService", stateService);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/viewState.jsp");
        dispatcher.forward(req, resp);
    }
}