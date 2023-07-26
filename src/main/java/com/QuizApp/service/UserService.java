package com.QuizApp.service;

import com.QuizApp.model.User;
import com.QuizApp.model.dto.CreateUserDto;
import com.QuizApp.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;
@RequiredArgsConstructor
public class UserService {
    private final JpaUserRepository jpaUserRepository;


    public void addUser(CreateUserDto createUserDto){
        if (!validateUserData(createUserDto)) {
            throw new RuntimeException(("invalid data for user: firstName was {}, " +
                    "lastName was {}, email was {}").formatted(createUserDto.getFirstName(),
                    createUserDto.getLastLogin(), createUserDto.getEmail()));
        }

        User user = new User();

        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setEmail(createUserDto.getEmail());
        user.setPasswordHash(createUserDto.getPasswordHash());
        user.setRegisteredAt(createUserDto.getRegisteredAt());
        user.setLastLogin(createUserDto.getLastLogin());

        jpaUserRepository.userRegistration(user);
    }

    public boolean validateUserData(CreateUserDto userDto) {
        String emailValidationPattern = "^(.+)@(.+)$";
        boolean emailIsOK = userDto.getEmail() != null && Pattern.compile(emailValidationPattern)
                .matcher(userDto.getEmail())
                .matches();
        boolean firstNameIsOk = userDto.getFirstName() != null && userDto.getFirstName().length() < 50;
        boolean lastNameIsOk = userDto.getLastName() != null && userDto.getLastName().length() < 50;

        return emailIsOK && firstNameIsOk && lastNameIsOk;
    }
}
