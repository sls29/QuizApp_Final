package com.QuizApp.service;

import com.QuizApp.model.Quiz;
import com.QuizApp.repository.JpaQuestionRepository;
import com.QuizApp.repository.JpaQuizRepository;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
public class QuizService {
    private final JpaQuizRepository jpaQuizRepository;

    public int getNumberOfQuizes(){
        return jpaQuizRepository.getNumberOfQuizes();
    }

    public List<Quiz> getNameOfQuizes(){
        return jpaQuizRepository.getNameOfQuizes();
    }

    public List<Integer> generateNumberQuestions (int maxNumber) {
        List<Integer> questions = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            int randNumber = (int) (Math.random() * (maxNumber - 1));
            questions.add(randNumber);
        }
        return questions;
    }



}
