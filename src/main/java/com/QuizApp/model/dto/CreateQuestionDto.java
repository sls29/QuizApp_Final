package com.QuizApp.model.dto;

import lombok.Data;

@Data
public class CreateQuestionDto {
    private String name;
    private String type;
    private int active;
    private int level;
    private int score;
    private String content;
}
