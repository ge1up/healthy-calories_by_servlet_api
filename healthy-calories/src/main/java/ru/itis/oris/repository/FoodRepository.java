package ru.itis.oris.repository;

import ru.itis.oris.model.FoodEntity;

import java.util.List;
import java.util.UUID;

public interface FoodRepository {

	FoodEntity findById(UUID uuid);

    List<FoodEntity> findAll();

    FoodEntity findByName(String foodName);

}
