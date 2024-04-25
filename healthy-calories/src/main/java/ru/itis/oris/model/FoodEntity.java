package ru.itis.oris.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class FoodEntity {
	private UUID uuid;
	private String name;
	private Integer caloriesNumber;
	private Integer proteinsNumber;
	private Integer carbohydratesNumber;
	private Integer fatsNumber;
	private Integer foodType;
}
