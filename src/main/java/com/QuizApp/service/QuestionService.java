package com.QuizApp.service;

import com.QuizApp.model.Answer;
import com.QuizApp.model.Question;
import com.QuizApp.model.dto.CreateAnswerDto;
import com.QuizApp.model.dto.CreateQuestionDto;
import com.QuizApp.repository.JpaQuestionRepository;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor

public class QuestionService {
    private final JpaQuestionRepository jpaQuestionRepository;

    public void addQuestion (CreateQuestionDto createQuestionDto,
                             LinkedList<CreateAnswerDto> answers){
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

        LinkedList<Answer> answersList = new LinkedList<Answer>();

        Answer answer = new Answer();

        for (CreateAnswerDto createAnswerDto : answers){
        answersList.add(new
                            (answer.setActive(createAnswerDto.getActive()),
                            answer.setCorrect(createAnswerDto.getCorrect());
                            answer.setContent(createAnswerDto.getContent()),
                            answer.setQuestion(createAnswerDto.getQuestion())));

        jpaQuestionRepository.questionImport(question, answersList);



    }
    public boolean validateQuestion(CreateQuestionDto questionDto){
            return questionDto.getContent() != null;
    }
    
    public boolean validateAnswers(LinkedList<CreateAnswerDto> answers){
            return answers.stream().anyMatch(Objects::nonNull);
    }
}
