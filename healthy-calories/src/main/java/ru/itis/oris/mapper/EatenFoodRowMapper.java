package ru.itis.oris.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.oris.model.EatenFoodEntity;
import ru.itis.oris.repository.EatenFoodRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class EatenFoodRowMapper implements RowMapper<EatenFoodEntity> {
    @Override
    public EatenFoodEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return EatenFoodEntity.builder()
                .uuid( (UUID) rs.getObject("uuid"))
                .userId( (UUID) rs.getObject("user_id"))
                .foodId( (UUID) rs.getObject("food_id"))
                .weight(rs.getInt("weight"))
                .createdDate(rs.getDate("created_date"))
                .build();
    }
}
