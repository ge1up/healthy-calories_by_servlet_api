package ru.itis.oris.repository;

import ru.itis.oris.model.EatenFoodEntity;
import ru.itis.oris.service.EatenFoodService;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

public interface EatenFoodRepository {

    List<EatenFoodEntity> findByDay(Date date);

    void create(String userId, UUID foodId, Integer weight);

}
