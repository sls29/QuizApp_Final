package com.QuizApp.model.dto;

import com.QuizApp.model.Answer;
import com.QuizApp.model.Question;


import lombok.Data;

@Data
public class AnswerDto {
    private int id;
    private String content;
    private int correct;
    private int active;
    private int question_id;

    public static AnswerDto toDto(Answer answer){
        AnswerDto answerDto = new AnswerDto();
        answerDto.setContent(answer.getContent());
        answerDto.setCorrect(answer.getCorrect());
        answerDto.setActive(answer.getActive());
        answerDto.setQuestion_id(answerDto.getQuestion_id());

    return answerDto;
    }
}
