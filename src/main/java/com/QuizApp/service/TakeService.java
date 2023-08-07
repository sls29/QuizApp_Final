package com.QuizApp.service;

import com.QuizApp.repository.JpaQuizRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TakeService {

    private final JpaQuizRepository jpaQuizRepository;
}
