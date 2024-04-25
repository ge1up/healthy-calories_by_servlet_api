package ru.itis.oris.mapper;

import ru.itis.oris.dto.UserRequest;
import ru.itis.oris.model.UserEntity;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserMapper {

    public UserRequest toUser (HttpServletRequest request) throws ParseException {
        return UserRequest.builder()
                .name(request.getParameter("name"))
                .surname(request.getParameter("surname"))
                .date(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("date")))
                .height(Integer.parseInt(request.getParameter("height")))
                .weight(Integer.parseInt(request.getParameter("weight")))
                .foodType(Integer.parseInt(request.getParameter("food_type")))
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();
    }
}
