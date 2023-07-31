package com.QuizApp.service;

import com.QuizApp.model.dto.CreateAnswerDto;
import com.QuizApp.model.dto.CreateQuestionDto;
import com.QuizApp.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
@RequiredArgsConstructor

public class QuestionService {
    private final JpaUserRepository jpaUserRepository;

    public void addQuestion (CreateQuestionDto createQuestionDto,
                             LinkedList<CreateAnswerDto> answers){

    }
}
