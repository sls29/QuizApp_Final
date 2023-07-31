package com.QuizApp.model.dto;

import com.QuizApp.model.Question;
import lombok.Data;

@Data
public class QuestionDto {
private int id;
private String name;
private String type;
private int active;
private int level;
private int score;
private String content;
public static QuestionDto toDto(Question question) {
    QuestionDto questionDto = new QuestionDto();
    questionDto.setName(question.getName());
    questionDto.setType(question.getType());
    questionDto.setActive(question.getActive());
    questionDto.setLevel(question.getLevel());
    questionDto.setScore(question.getScore());
    questionDto.setContent(question.getContent());

return questionDto;
    }
}


