package ru.itis.oris.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class UserEntity {
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
