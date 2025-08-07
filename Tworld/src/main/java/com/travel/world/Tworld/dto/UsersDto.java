package com.travel.world.Tworld.dto;

import lombok.Data;

@Data
public class UsersDto {

    private String username;

    private String password;

    private String role; // Example: "ROLE_USER", "ROLE_ADMIN"


}
