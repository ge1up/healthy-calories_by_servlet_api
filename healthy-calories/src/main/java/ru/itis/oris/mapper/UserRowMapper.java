package ru.itis.oris.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.oris.model.UserEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        return UserEntity.builder()
                .uuid((UUID) rs.getObject("uuid"))
                .name(rs.getString("name"))
                .surname(rs.getString("surname"))
                .date(rs.getDate("date"))
                .height(rs.getInt("height"))
                .weight(rs.getInt("weight"))
                .foodType(rs.getInt("food_type"))
                .email(rs.getString("email"))
                .password(rs.getString("password"))
                .build();
    }
}
