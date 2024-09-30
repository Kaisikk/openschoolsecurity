package com.kaisik.openschoolsecurity.dto;

import lombok.Data;

/**
 * Dto юзера
 */
@Data
public class UserDto {
    String userId;
    String firstName;
    String lastName;
    String email;
    String password;
}
