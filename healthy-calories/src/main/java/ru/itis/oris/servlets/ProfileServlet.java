package ru.itis.oris.servlets;

import ru.itis.oris.model.UserEntity;
import ru.itis.oris.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UUID uuid = UUID.fromString(req.getSession().getAttribute("user").toString());

        try {
            UserEntity user = userService.findByUuid(uuid);
            req.setAttribute("user", user);
            req.getRequestDispatcher("profile.ftl").forward(req, resp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            req.getSession(true).removeAttribute("user");
            req.setAttribute("errorMessage", e.getMessage());
            resp.sendRedirect("sign-in");
        }

    }
}
