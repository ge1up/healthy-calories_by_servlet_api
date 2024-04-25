package ru.itis.oris.service;

import ru.itis.oris.model.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.UUID;

public interface UserService {

    UUID create(HttpServletRequest request);

    void signIn(HttpServletRequest request);

	UserEntity findByUuid(UUID uuid);

    UserEntity findByEmail(String email);

	void deleteById(UUID uuid);

	void editById(UUID uuid, HttpServletRequest request) throws ParseException;

}
