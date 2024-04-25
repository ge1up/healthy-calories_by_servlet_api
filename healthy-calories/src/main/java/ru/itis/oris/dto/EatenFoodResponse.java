package ru.itis.oris.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
@AllArgsConstructor
public class EatenFoodResponse {
	private String foodName;
	private Integer weight;
	private Integer caloriesNumber;
	private Integer proteinsNumber;
	private Integer carbohydratesNumber;
	private Integer fatsNumber;
	private Date createdDate;
}
