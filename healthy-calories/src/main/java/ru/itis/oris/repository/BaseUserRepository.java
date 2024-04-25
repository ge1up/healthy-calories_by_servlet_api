package ru.itis.oris.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import ru.itis.oris.dto.UserRequest;
import ru.itis.oris.mapper.UserRowMapper;
import ru.itis.oris.model.UserEntity;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class BaseUserRepository implements UserRepository{

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper rowMapper;

    private final static String SQL_CREATE = "insert into users " +
            "(name, surname, date, height, weight, food_type, email, password)" +
            "values (?, ?, ?, ?, ?, ?, ?, ?)";

    private final static String SQL_FIND_BY_EMAIL = "select * from users where email = ?";

    private final static String SQL_FIND_BY_UUID = "select * from users where uuid = ?";

    private final static String SQL_DELETE_BY_ID = "delete from users where uuid = ?";

    private final static String SQL_UPDATE_BY_ID = new StringBuilder("update users set name = ?, surname = ?, ").append(
            "date = ?, height = ?, weight = ?, food_type = ?, email = ?, password = ? where uuid = ?").toString();

    @Override
    public UUID create(UserRequest user) {
        //try {
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setDate(3, new Date(user.getDate().getTime()));
            preparedStatement.setInt(4, user.getHeight());
            preparedStatement.setInt(5, user.getWeight());
            preparedStatement.setInt(6, user.getFoodType());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getPassword());
            return preparedStatement;
        }, keyHolder);
        return (UUID) keyHolder.getKeys().get("uuid");

    }

    @Override
    public UserEntity findByUuid(UUID uuid) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_UUID, rowMapper, uuid);
    }

    @Override
    public boolean userExistenceByEmail(String email) {
        return jdbcTemplate.query(SQL_FIND_BY_EMAIL, rowMapper, email).size() != 0;
    }

    @Override
    public void deleteById(UUID uuid) {
        jdbcTemplate.update(SQL_DELETE_BY_ID, uuid);
    }

    @Override
    public void editById(UUID uuid, UserRequest user) {
        jdbcTemplate.update(SQL_UPDATE_BY_ID, user.getName(), user.getSurname(), user.getDate(), user.getHeight(), user.getWeight(), user.getFoodType(), user.getEmail(), user.getPassword(), uuid);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, rowMapper, email);
    }
}
