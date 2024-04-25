package ru.itis.oris.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // преобразуем запросы к нужному виду
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (request.getRequestURI().equals("/")) {
            filterChain.doFilter(request, response);
            return;
        }

        // берем сессию у запроса
        // берем только существующую, если сессии не было - то вернет null
        HttpSession session = request.getSession(false);

        // флаг, аутентифицирован ли пользователь
        boolean isAuthenticated = false;

        // существует ли сессия вообще?
        boolean sessionExists = session != null;

        // идет ли запрос на страницу входа или регистрации?
        boolean isRequestOnAuthPage = request.getRequestURI().contains("sign-in") ||
                request.getRequestURI().contains("sign-up");

        // если сессия есть
        if (sessionExists) {
            // проверим, есть ли атрибует user?
            isAuthenticated = session.getAttribute("user") != null;
        }

        if (isRequestOnAuthPage) {
            if (isAuthenticated)
                response.sendRedirect("profile");
            else
                filterChain.doFilter(request, response);
        } else {
            if (isAuthenticated)
                filterChain.doFilter(request, response);
            else
                response.sendRedirect("sign-in");
        }

    }

    @Override
    public void destroy() {}
}
