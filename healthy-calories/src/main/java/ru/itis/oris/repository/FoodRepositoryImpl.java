package ru.itis.oris.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.oris.mapper.FoodRowMapper;
import ru.itis.oris.model.FoodEntity;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class FoodRepositoryImpl implements FoodRepository {

	private final JdbcTemplate jdbcTemplate;

	private final FoodRowMapper foodMapper;

	private final String SQL_FIND_BY_UUID = "select * from foods where uuid = ?";

	private final String SQL_FIND_BY_NAME = "select * from foods where name = ?";

	private final String SQL_FIND_ALL = "select * from foods";

	@Override
	public FoodEntity findById(UUID uuid) {
		return jdbcTemplate.queryForObject(SQL_FIND_BY_UUID, foodMapper, uuid);
	}

	@Override
	public List<FoodEntity> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, foodMapper);
	}

	@Override
	public FoodEntity findByName(String foodName) {
		return jdbcTemplate.queryForObject(SQL_FIND_BY_NAME, foodMapper, foodName);
	}
}
