package com.QuizApp.repository;

import com.QuizApp.model.Question;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.LinkedList;

public class JpaQuestionRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");
    public void questionImport(Question question, LinkedList<> answers) {

    }
}
