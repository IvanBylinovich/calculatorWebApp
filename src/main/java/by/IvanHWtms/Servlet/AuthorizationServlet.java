package by.IvanHWtms.Servlet;

import by.IvanHWtms.DAO.InMemoryUserDao;
import by.IvanHWtms.Entity.User;
import by.IvanHWtms.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/auth", name = "AuthorizationServlet")
public class AuthorizationServlet extends HttpServlet {
    private final UserService userService = new UserService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        InMemoryUserDao us = new InMemoryUserDao();
        String ans = "";

        if(login.equals("")|| password.equals("")){
            ans = "You forgot to enter your username or password";
            req.setAttribute("ans", ans);
            getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);
        }else{
            User byLogin = userService.getByLogin(login);
                if (byLogin != null && byLogin.getPassword().equals(password)) {
                    req.getSession().setAttribute("user", byLogin);
                    getServletContext().getRequestDispatcher("/Calculator.jsp").forward(req, resp);
                }else{
                    ans = "wrong password or login";
                    req.setAttribute("ans", ans);
                    getServletContext().getRequestDispatcher("/Authorization.jsp").forward(req, resp);
                }
        }
    }
}
