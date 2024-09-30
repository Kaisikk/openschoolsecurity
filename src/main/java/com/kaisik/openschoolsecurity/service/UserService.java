package com.kaisik.openschoolsecurity.service;

import com.kaisik.openschoolsecurity.dto.JwtAuthenticationDto;
import com.kaisik.openschoolsecurity.dto.RefreshTokenDto;
import com.kaisik.openschoolsecurity.dto.UserCredentialsDto;
import com.kaisik.openschoolsecurity.dto.UserDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import javax.naming.AuthenticationException;

public interface UserService {

    JwtAuthenticationDto singIn(UserCredentialsDto userCredentialsDto) throws AuthenticationException;
    JwtAuthenticationDto refreshToken(RefreshTokenDto refreshTokenDto) throws Exception;
    UserDto getUserById(String id) throws ChangeSetPersister.NotFoundException;
    UserDto getUserByEmail(String email) throws ChangeSetPersister.NotFoundException;
    String addUser(UserDto user);


}
