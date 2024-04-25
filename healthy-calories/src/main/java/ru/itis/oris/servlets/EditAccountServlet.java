package ru.itis.oris.servlets;

import jdk.jshell.spi.ExecutionControl;
import jdk.jshell.spi.ExecutionEnv;
import ru.itis.oris.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.UUID;

@WebServlet("/account-change")
public class EditAccountServlet extends HttpServlet {

	private UserService userService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		userService = (UserService) config.getServletContext().getAttribute("userService");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("account-change.ftl").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			userService.editById( (UUID) req.getSession(true).getAttribute("user"), req);
			resp.sendRedirect("profile");
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

	}

}
