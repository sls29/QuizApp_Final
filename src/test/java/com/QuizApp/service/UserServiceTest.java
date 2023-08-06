package com.QuizApp.service;

import com.QuizApp.model.dto.CreateUserDto;
import org.junit.jupiter.api.Assertions;

class UserServiceTest {

    @org.junit.jupiter.api.Test
    void validateUserData() throws Exception{
        CreateUserDto userDto = new CreateUserDto();
        boolean ans = true;
        boolean val;

        userDto.setFirstName("Boys");
        userDto.setLastName("Bingo");
        userDto.setEmail("bingoboy@smail.com");
        userDto.setPasswordHash(null);
        userDto.setLastLogin(null);
        userDto.setRegisteredAt(null);

        val = UserService.validateUserData(userDto);
        Assertions.assertEquals(ans, val);
    }
}