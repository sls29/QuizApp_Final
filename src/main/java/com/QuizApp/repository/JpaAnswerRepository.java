package com.QuizApp.repository;

import com.QuizApp.model.Answer;
import com.QuizApp.model.Question;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaAnswerRepository {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");
    EntityManager entityManager = emFactory.createEntityManager();

    public void answerImport(Answer answer) {
        entityManager.getTransaction().begin();
        entityManager.persist(answer);
        entityManager.getTransaction().commit();
    }

//        entityManager.close();

}