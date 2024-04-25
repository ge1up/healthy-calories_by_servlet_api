package ru.itis.oris.servlets;

import lombok.RequiredArgsConstructor;
import ru.itis.oris.exception.UserException;
import ru.itis.oris.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequiredArgsConstructor
@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) {
        ServletContext servletContext = config.getServletContext();
        userService = (UserService) servletContext.getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign-up.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid;
        try {
            uuid = userService.create(req).toString();
        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("sign-up.ftl").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession(true);
        session.setAttribute("user", uuid);
        resp.sendRedirect("profile");
    }
}
