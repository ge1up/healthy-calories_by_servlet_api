package ru.itis.oris.servlets;

import lombok.RequiredArgsConstructor;
import ru.itis.oris.dto.UserRequest;
import ru.itis.oris.exception.UserException;
import ru.itis.oris.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-in")
@RequiredArgsConstructor
public class SignInServlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("sign-in.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            userService.signIn(req);
            req.getSession(true).setAttribute("user", userService.findByEmail(req.getParameter("email")).getUuid());
            resp.sendRedirect("profile");
        } catch (Exception e) {
            req.setAttribute("errorMessage", e.getMessage());
            resp.sendRedirect("sign-in");
            return;
        }
    }
}
