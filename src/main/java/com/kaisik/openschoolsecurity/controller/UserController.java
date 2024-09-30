package com.kaisik.openschoolsecurity.controller;

import com.kaisik.openschoolsecurity.dto.UserDto;
import com.kaisik.openschoolsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * Регистрация нового пользователя
     *
     * @param userDto
     * @return
     */
    @PostMapping("/registration")
    public String createUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    /**
     * Получение юзера по id
     *
     * @param id
     * @return
     * @throws ChangeSetPersister.NotFoundException
     */
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable String id) throws ChangeSetPersister.NotFoundException {
        return userService.getUserById(id);
    }

    /**
     * Получение юзера по почте
     *
     * @param email
     * @return
     * @throws ChangeSetPersister.NotFoundException
     */
    @GetMapping("/email/{email}")
    public UserDto getUserByEmail(@PathVariable String email) throws ChangeSetPersister.NotFoundException {
        return userService.getUserByEmail(email);
    }
}