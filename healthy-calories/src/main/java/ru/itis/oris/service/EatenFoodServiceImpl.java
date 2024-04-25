package ru.itis.oris.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import ru.itis.oris.dto.EatenFoodRequest;
import ru.itis.oris.dto.EatenFoodResponse;
import ru.itis.oris.model.EatenFoodEntity;
import ru.itis.oris.model.FoodEntity;
import ru.itis.oris.repository.EatenFoodRepository;
import ru.itis.oris.repository.FoodRepository;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.ceil;
import static java.lang.Math.round;

@RequiredArgsConstructor
public class EatenFoodServiceImpl implements EatenFoodService {

	private final EatenFoodRepository eatenFoodRepository;

	private final FoodService foodService;

	@Override
	public List<EatenFoodResponse> getByDay(HttpServletRequest request) {

		Integer requestDay = Integer.parseInt(request.getParameter("day"));

		long millisInDay = 86400000; // количество миллисекунд в сутках
		Date date = new Date(System.currentTimeMillis() - millisInDay * requestDay);
		List<EatenFoodEntity> eatenFoods = eatenFoodRepository.findByDay(date);

		List<EatenFoodResponse> result = new ArrayList<>();
		for (EatenFoodEntity eatenFood : eatenFoods) {
			FoodEntity food = foodService.getById(eatenFood.getFoodId());
			result.add(EatenFoodResponse.builder()
					.foodName(food.getName())
					.weight(eatenFood.getWeight())
					.caloriesNumber(round(((float) eatenFood.getWeight() / 100) * food.getCaloriesNumber()))
					.proteinsNumber(round(((float) eatenFood.getWeight() / 100) * food.getProteinsNumber()))
					.carbohydratesNumber(round(((float) eatenFood.getWeight() / 100) * food.getCarbohydratesNumber()))
					.fatsNumber(round(((float) eatenFood.getWeight() / 100) * food.getFatsNumber()))
					.createdDate(eatenFood.getCreatedDate())
					.build());
		}

		return result;

	}

	@Override
	public void create(HttpServletRequest req) {

		EatenFoodRequest eatenFood = null;
		try {
			eatenFood = new ObjectMapper().readValue(req.getReader().readLine(), EatenFoodRequest.class);
		} catch (IOException e) {
            throw new RuntimeException(e);
        }

		eatenFoodRepository.create(req.getSession(true).getAttribute("user").toString(), foodService.getByName(eatenFood.getFoodName()).getUuid(), eatenFood.getWeight());

	}
}
