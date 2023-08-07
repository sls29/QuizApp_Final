package com.QuizApp.service;

import com.QuizApp.model.Question;
import com.QuizApp.model.dto.CreateQuestionDto;
import com.QuizApp.repository.JpaQuestionRepository;
import lombok.RequiredArgsConstructor;
import java.util.*;

@RequiredArgsConstructor
public class QuestionService {
    private final JpaQuestionRepository jpaQuestionRepository;

    public void addQuestion(CreateQuestionDto createQuestionDto) {
//        if (!validateQuestion(createQuestionDto)) {
//            throw new RuntimeException("Check the question list for consistence");
//        }
        Question question = new Question();
        question.setName(createQuestionDto.getName());
        question.setType(createQuestionDto.getType());
        question.setLevel(createQuestionDto.getLevel());
        question.setActive(createQuestionDto.getActive());
        question.setScore(createQuestionDto.getScore());
        question.setContent((createQuestionDto.getContent()));

        jpaQuestionRepository.questionImport(question);
    }

    public int getNumberOfQuestions(){
        return jpaQuestionRepository.getNumberOfQuestions();
    }

    private boolean validateQuestion(CreateQuestionDto createQuestionDto) {
        boolean questionIsOk = createQuestionDto.getContent() != null;

        return questionIsOk;
    }

    public List<Question> getAllQuizQuestions(int quiz_id){
        return jpaQuestionRepository.getQuizQuestions( quiz_id);
    }

}
