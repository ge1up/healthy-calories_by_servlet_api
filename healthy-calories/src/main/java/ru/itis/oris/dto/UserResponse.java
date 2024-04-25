package ru.itis.oris.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class UserResponse {
    private UUID uuid;
    private String name;
    private String surname;
    private Date date;
    private Integer height;
    private Integer weight;
    private Integer foodType;
    private String email;
    private String password;
}
