package com.QuizApp.model.dto;

import com.QuizApp.model.Question;
import lombok.Data;

@Data
public class CreateAnswerDto {
    private String content;
    private int correct;
    private int active;
    private Question Question;

}
