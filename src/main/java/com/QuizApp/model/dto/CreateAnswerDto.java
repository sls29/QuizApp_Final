package com.QuizApp.model.dto;

import lombok.Data;

@Data
public class CreateAnswerDto {
    private String content;
    private int correct;
    private int active;

}
