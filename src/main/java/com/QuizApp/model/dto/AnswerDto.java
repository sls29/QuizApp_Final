package com.QuizApp.model.dto;

import com.QuizApp.model.Answer;
import lombok.Data;

@Data
public class AnswerDto {
    private int id;
    private String content;
    private int correct;
    private int active;

    public static AnswerDto toDto(Answer answer){
        AnswerDto answerDto = new AnswerDto();
        answerDto.setContent(answer.getContent());
        answerDto.setCorrect(answer.getCorrect());
        answerDto.setActive(answer.getActive());

    return answerDto;
    }
}
