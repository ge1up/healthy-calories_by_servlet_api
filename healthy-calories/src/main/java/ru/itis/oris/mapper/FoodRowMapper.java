package ru.itis.oris.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.itis.oris.model.FoodEntity;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FoodRowMapper implements RowMapper<FoodEntity> {
	@Override
	public FoodEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		return FoodEntity.builder()
				.uuid( (UUID) rs.getObject("uuid"))
				.name(rs.getString("name"))
				.caloriesNumber(rs.getInt("calories_number"))
				.proteinsNumber(rs.getInt("proteins_number"))
				.carbohydratesNumber(rs.getInt("carbohydrates_number"))
				.fatsNumber(rs.getInt("fats_number"))
				.foodType(rs.getInt("food_type"))
				.build();
	}
}
