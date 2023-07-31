package com.QuizApp.repository;

import com.QuizApp.model.Answer;
import com.QuizApp.model.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.LinkedList;

public class JpaQuestionRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");
    EntityManager entityManager = emFactory.createEntityManager();

    public void questionImport(Question question, LinkedList<Answer> answersList) {
        entityManager.getTransaction().begin();
        entityManager.persist(question);
        entityManager.getTransaction().commit();

        for (Answer answer : answersList) {
            entityManager.getTransaction().begin();
            entityManager.persist(answer);
            entityManager.getTransaction().commit();
        }

//        entityManager.close();

    }
}
