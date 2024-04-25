package ru.itis.oris.service;

import lombok.RequiredArgsConstructor;
import ru.itis.oris.dto.FoodResponse;
import ru.itis.oris.mapper.FoodMapper;
import ru.itis.oris.model.FoodEntity;
import ru.itis.oris.repository.FoodRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {

	private final FoodRepository foodRepository;

	private final FoodMapper foodMapper;

	@Override
	public FoodEntity getById(UUID uuid) {
		return foodRepository.findById(uuid);
	}

	@Override
	public List<FoodResponse> getAll() {
		List<FoodResponse> responses = new ArrayList<>();
		for (FoodEntity food : foodRepository.findAll()) {
			responses.add(foodMapper.toEntity(food));
		}
		return responses;
	}

	@Override
	public FoodEntity getByName(String foodName) {
		return foodRepository.findByName(foodName);
	}
}
