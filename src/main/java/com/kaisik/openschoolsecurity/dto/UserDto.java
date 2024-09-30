package com.kaisik.openschoolsecurity.dto;

import lombok.Data;

@Data
public class UserDto {
    String userId;
    String firstName;
    String lastName;
    String email;
    String password;
}
