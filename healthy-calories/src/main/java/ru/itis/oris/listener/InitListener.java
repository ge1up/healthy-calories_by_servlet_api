package ru.itis.oris.listener;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.oris.mapper.*;
import ru.itis.oris.model.EatenFoodEntity;
import ru.itis.oris.repository.*;
import ru.itis.oris.service.*;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitListener implements ServletContextListener {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/healthy-calories";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "sqlpassword";
    private static final String DB_DRIVER = "org.postgresql.Driver";

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Postgresql Driver not found.");
        }

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(DB_DRIVER);
        dataSource.setUsername(DB_USERNAME);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setUrl(DB_URL);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        UserMapper userMapper = new UserMapper();
        UserRowMapper userRowMapper = new UserRowMapper();
        UserRepository userRepository = new BaseUserRepository(jdbcTemplate, userRowMapper);
        UserService userService = new BaseUserService(userMapper, userRepository);

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("userService", userService);

        FoodRowMapper foodRowMapper = new FoodRowMapper();
        FoodMapper foodMapper = new FoodMapper();
        FoodRepository foodRepository = new FoodRepositoryImpl(jdbcTemplate, foodRowMapper);
        FoodService foodService = new FoodServiceImpl(foodRepository, foodMapper);

        servletContext.setAttribute("foodService", foodService);

        EatenFoodRowMapper eatenFoodRowMapper = new EatenFoodRowMapper();
        EatenFoodRepository eatenFoodRepository = new EatenFoodRepositoryImpl(jdbcTemplate, eatenFoodRowMapper);
        EatenFoodService eatenFoodService = new EatenFoodServiceImpl(eatenFoodRepository, foodService);

        servletContext.setAttribute("eatenFoodService", eatenFoodService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
