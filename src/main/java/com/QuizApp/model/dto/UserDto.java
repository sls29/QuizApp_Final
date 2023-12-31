package com.QuizApp.model.dto;

import com.QuizApp.model.User;
import lombok.Data;


@Data
public class UserDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordHash;
    private String registeredAt;
    private String lastLogin;

    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setPasswordHash(userDto.getPasswordHash());
        userDto.setRegisteredAt(userDto.getRegisteredAt());
        userDto.setLastLogin(userDto.getLastLogin());

        return userDto;
    }
}
