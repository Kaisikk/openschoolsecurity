package com.kaisik.openschoolsecurity.dto;

import lombok.Data;

/**
 * Объект для работы с контроллерами
 */
@Data
public class UserCredentialsDto {

    private String email;
    private String password;

}
