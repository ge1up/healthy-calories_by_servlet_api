package ru.itis.oris.dto;


import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class UserRequest {
    private String name;
    private String surname;
    private Date date;
    private Integer height;
    private Integer weight;
    private Integer foodType;
    private String email;
    private String password;
}
