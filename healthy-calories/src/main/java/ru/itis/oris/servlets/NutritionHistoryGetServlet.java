package ru.itis.oris.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.oris.dto.EatenFoodResponse;
import ru.itis.oris.service.EatenFoodService;
import ru.itis.oris.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/nutrition_history/get")
public class NutritionHistoryGetServlet extends HttpServlet {

    private EatenFoodService eatenFoodService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        eatenFoodService = (EatenFoodService) config.getServletContext().getAttribute("eatenFoodService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<EatenFoodResponse> eatenFoods = eatenFoodService.getByDay(req);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(eatenFoods);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);

    }
}
