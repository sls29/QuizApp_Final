package com.QuizApp.repository;

import com.QuizApp.model.Answer;
import com.QuizApp.model.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.LinkedList;

public class JpaQuestionRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");
    public void questionImport(Question question, LinkedList<Answer> answersList) {
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(question);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
