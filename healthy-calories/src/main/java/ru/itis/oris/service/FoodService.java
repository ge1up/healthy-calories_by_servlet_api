package ru.itis.oris.service;

import ru.itis.oris.dto.FoodResponse;
import ru.itis.oris.model.FoodEntity;

import java.util.List;
import java.util.UUID;

public interface FoodService {

	FoodEntity getById(UUID uuid);

    List<FoodResponse> getAll();

    FoodEntity getByName(String foodName);

}
