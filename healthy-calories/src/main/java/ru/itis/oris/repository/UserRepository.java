package ru.itis.oris.repository;

import ru.itis.oris.dto.UserRequest;
import ru.itis.oris.model.UserEntity;

import java.util.UUID;

public interface UserRepository {

    UUID create(UserRequest user);

    UserEntity findByUuid(UUID uuid);

    UserEntity findByEmail(String email);

    boolean userExistenceByEmail(String name);

	void deleteById(UUID uuid);

	void editById(UUID uuid, UserRequest user);

}
