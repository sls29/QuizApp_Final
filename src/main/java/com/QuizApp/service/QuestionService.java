package com.QuizApp.service;

import com.QuizApp.model.Answer;
import com.QuizApp.model.Question;
import com.QuizApp.model.dto.CreateAnswerDto;
import com.QuizApp.model.dto.CreateQuestionDto;
import com.QuizApp.repository.JpaQuestionRepository;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.*;
import java.util.Objects;

@RequiredArgsConstructor
public class QuestionService {
    private final JpaQuestionRepository jpaQuestionRepository;

    public void addQuestion(CreateQuestionDto createQuestionDto,
                            List<CreateAnswerDto> answers) {
        if (!validateQuestion(createQuestionDto) && !validateAnswers( answers)) {
            throw new RuntimeException("Check the question list for consistence");
        }
        Question question = new Question();
        question.setName(createQuestionDto.getName());
        question.setType(createQuestionDto.getType());
        question.setLevel(createQuestionDto.getLevel());
        question.setActive(createQuestionDto.getActive());
        question.setScore(createQuestionDto.getScore());
        question.setContent((createQuestionDto.getContent()));

        List<Answer> answersList = new ArrayList<>();

        Answer answer = new Answer();
        for (CreateAnswerDto createAnswerDto : answers) {
            answer.setActive(createAnswerDto.getActive());
            answer.setCorrect(createAnswerDto.getCorrect());
            answer.setContent(createAnswerDto.getContent());
            answer.setQuestion(createAnswerDto.getQuestion());
            answersList.add(answer);
        }
            jpaQuestionRepository.questionImport(question, answersList);
    }

    private boolean validateAnswers(List<CreateAnswerDto> answers) {
        boolean answerIsOk = answers.stream().anyMatch(Objects::nonNull);

        return answerIsOk;
    }

    private boolean validateQuestion(CreateQuestionDto createQuestionDto) {
        boolean questionIsOk = createQuestionDto.getContent() != null;

        return questionIsOk;
    }
}
