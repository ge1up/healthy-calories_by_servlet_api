package ru.itis.oris.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.itis.oris.dto.EatenFoodResponse;
import ru.itis.oris.dto.FoodResponse;
import ru.itis.oris.model.FoodEntity;
import ru.itis.oris.service.FoodService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/foods/get")
public class FoodGetServlet extends HttpServlet {

    private FoodService foodService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        foodService = (FoodService) config.getServletContext().getAttribute("foodService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<FoodResponse> foods = foodService.getAll();

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(foods);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonResponse);

    }
}
