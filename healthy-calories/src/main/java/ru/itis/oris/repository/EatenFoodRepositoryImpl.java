package ru.itis.oris.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.oris.mapper.EatenFoodRowMapper;
import ru.itis.oris.model.EatenFoodEntity;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class EatenFoodRepositoryImpl implements EatenFoodRepository {

    private final JdbcTemplate jdbcTemplate;

    private final EatenFoodRowMapper rowMapper;

    private final String SQL_CREATE = "insert into eaten_foods (user_id, food_id, weight) values (?, ?, ?)";

    private final String SQL_FIND_BY_DAY = "select * from eaten_foods where created_date = ?";

    @Override
    public List<EatenFoodEntity> findByDay(Date date) {
        return jdbcTemplate.query(SQL_FIND_BY_DAY, rowMapper, date);
    }

    @Override
    public void create(String userId, UUID foodId, Integer weight) {
        jdbcTemplate.update(SQL_CREATE, UUID.fromString(userId), foodId, weight);
    }
}
