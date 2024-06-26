package ru.itis.oris.servlets;

import ru.itis.oris.service.EatenFoodService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/nutrition_history")
public class NutritionHistoryServlet extends HttpServlet {

    private EatenFoodService eatenFoodService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        eatenFoodService = (EatenFoodService) config.getServletContext().getAttribute("eatenFoodService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("nutrition_history.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        eatenFoodService.create(req);

    }
}
