package ru.itis.oris.service;

import lombok.RequiredArgsConstructor;
import ru.itis.oris.dto.UserRequest;
import ru.itis.oris.exception.UserException;
import ru.itis.oris.mapper.UserMapper;
import ru.itis.oris.mapper.UserRowMapper;
import ru.itis.oris.model.UserEntity;
import ru.itis.oris.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
public class BaseUserService implements UserService {

    private final UserMapper userMapper;

    private final UserRepository userRepository;

    @Override
    public UUID create(HttpServletRequest request) {

        UserRequest user;
        try {
            user = userMapper.toUser(request);
        } catch (Exception e) {
            throw new UserException("Request can not be parsed (" + e.getMessage() + ')');
        }

        if (userRepository.userExistenceByEmail(user.getEmail())) {
            throw new UserException("User with this Email already exist");
        }

        return userRepository.create(user);
    }

    @Override
    public void signIn(HttpServletRequest request) {
        UserRequest userRequest = UserRequest.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();

        String userPassword;
        userPassword = userRepository.findByEmail(userRequest.getEmail()).getPassword();
        if (userPassword.equals(userRequest.getPassword())) {
            return;
        } else {
            throw new UserException("Invalid username or password");
        }

    }

    @Override
    public UserEntity findByUuid(UUID uuid) {
        return userRepository.findByUuid(uuid);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void deleteById(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    @Override
    public void editById(UUID uuid, HttpServletRequest request) throws ParseException {

        UserEntity user = userRepository.findByUuid(uuid);
        try {
            userRepository.findByEmail(request.getParameter(user.getEmail()));
            throw new RuntimeException();
        } catch (Exception e) {
            userRepository.editById(uuid, userMapper.toUser(request));
        }

    }
}

