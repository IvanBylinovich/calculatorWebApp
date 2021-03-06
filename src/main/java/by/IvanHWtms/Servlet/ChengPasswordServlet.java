package by.IvanHWtms.Servlet;

import by.IvanHWtms.Entity.User;
import by.IvanHWtms.Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/chengPassword", name = "ChengPasswordServlet")
public class ChengPasswordServlet extends HttpServlet {

    UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/ChengPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.chengPassword(((User)req.getSession().getAttribute("user")).getLogin(), req.getParameter("password"));

        resp.sendRedirect("/calc");
    }
}
