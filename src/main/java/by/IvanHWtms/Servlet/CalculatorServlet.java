package by.IvanHWtms.Servlet;

import by.IvanHWtms.Entity.Session;
import by.IvanHWtms.Entity.User;
import by.IvanHWtms.Service.MathService;
import by.IvanHWtms.Service.SessionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Integer.parseInt;

@WebServlet(urlPatterns = "/calc", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            User user = (User) req.getSession().getAttribute("user");

        }catch(NullPointerException e){

            resp.getWriter().println("you need to log in");
        }



            getServletContext().getRequestDispatcher("/Calculator.jsp").forward(req, resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");

        String a = req.getParameter("a");
        String b = req.getParameter("b");
        String operation = req.getParameter("operation");

        String res = MathService.mathOperation(a, b, operation);



            int a_Int = parseInt(a);
            int b_Int = parseInt(b);


            SessionService sessionService = new SessionService();
            sessionService.addSessionInfo(new Session(user.getName(), a_Int, b_Int, operation, res));

        req.setAttribute("res", res);
        req.setAttribute("sessions", sessionService.getSessionInfo());
        getServletContext().getRequestDispatcher("/Calculator.jsp").forward(req, resp);

    }
}
