package ru.itis.oris.servlets;

import ru.itis.oris.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sign-out")
public class SignOutServlet extends HttpServlet {

	private UserService userService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		userService = (UserService) config.getServletContext().getAttribute("userService");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession(true).removeAttribute("user");
		resp.sendRedirect("/sign-in");

	}
}
