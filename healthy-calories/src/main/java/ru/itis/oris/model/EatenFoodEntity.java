package ru.itis.oris.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class EatenFoodEntity {
	private UUID uuid;
	private UUID userId;
	private UUID foodId;
	private Integer weight;
	private Date createdDate;
}
