package by.IvanHWtms.Servlet;

import by.IvanHWtms.DAO.InMemorySessionDAO;
import by.IvanHWtms.DAO.InMemoryUserDao;
import by.IvanHWtms.Entity.User;
import by.IvanHWtms.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Registration.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        InMemoryUserDao us = new InMemoryUserDao();
        Boolean flag = false;
        User user = null;
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if(name.equals("") && login.equals("") && password.equals("") ){
            flag = true;
            req.setAttribute("flag", flag);
            getServletContext().getRequestDispatcher("/Registration.jsp").forward(req,resp);

        }else{
            user = new User(0, name, login, password);
        }


        if (userService.add(user)) {

            getServletContext().getRequestDispatcher("/").forward(req, resp);
        } else {
            flag = true;
            req.setAttribute("flag", flag);
            getServletContext().getRequestDispatcher("/Registration.jsp").forward(req,resp);

        }
    }
}
