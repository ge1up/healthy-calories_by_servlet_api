package ru.itis.oris.service;

import ru.itis.oris.dto.EatenFoodRequest;
import ru.itis.oris.dto.EatenFoodResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

public interface EatenFoodService {
	List<EatenFoodResponse> getByDay(HttpServletRequest request);

    void create(HttpServletRequest req);

}
