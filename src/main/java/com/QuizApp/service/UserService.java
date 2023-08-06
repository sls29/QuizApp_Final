package com.QuizApp.service;

import com.QuizApp.model.User;
import com.QuizApp.model.dto.CreateUserDto;
import com.QuizApp.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.regex.Pattern;

@RequiredArgsConstructor
public class UserService {
    private final JpaUserRepository jpaUserRepository;

    public void updateLastLoginDate(String email, String loginTime) {
        jpaUserRepository.updateLastLoginDate(email, loginTime);
    }

    public boolean validateUserLogin(String email, String password) {
        if (!findUser(jpaUserRepository.getAllUsers(), email, password)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean findUser(List<User> userList, String email, String password) {
        return (userList.stream()
                .anyMatch(p -> p.getEmail().equals(email)&&p.getPasswordHash().equals(password)));
    }

    public void addUser(
            CreateUserDto createUserDto) {
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



//        if (jpaUserRepository.findUser(createUserDto.getEmail())) {
//            throw new RuntimeException("User found in DB");
//        } else {
             jpaUserRepository.userRegistration(user);
//        }

    }
    public void deleteUser (String email){
        if (jpaUserRepository.findUser(email)){
        jpaUserRepository.findAndDeleteUserByEmail(email);
        } else {
            throw new RuntimeException ("User not found in DB");
        }
        }


    public static boolean validateUserData(CreateUserDto userDto) {
        String emailValidationPattern = "^(.+)@(.+)$";
        boolean emailIsOK = userDto.getEmail() != null && Pattern.compile(emailValidationPattern)
                .matcher(userDto.getEmail())
                .matches();
        boolean firstNameIsOk = userDto.getFirstName() != null && userDto.getFirstName().length() < 50;
        boolean lastNameIsOk = userDto.getLastName() != null && userDto.getLastName().length() < 50;

        return emailIsOK && firstNameIsOk && lastNameIsOk;
    }
}
