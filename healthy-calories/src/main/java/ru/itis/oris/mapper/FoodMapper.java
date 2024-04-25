package ru.itis.oris.mapper;


import ru.itis.oris.dto.FoodResponse;
import ru.itis.oris.model.FoodEntity;

public class FoodMapper {

    public FoodResponse toEntity(FoodEntity food) {
        return FoodResponse.builder()
                .name(food.getName())
                .build();
    }

}
