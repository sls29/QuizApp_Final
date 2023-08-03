package com.QuizApp.repository;

import com.QuizApp.model.Question;
import com.QuizApp.model.Quiz;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpaQuizRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");
    EntityManager entityManager = emFactory.createEntityManager();


    public int getNumberOfQuizes() {
        TypedQuery<Quiz> typedQuery = entityManager.createQuery(
                "select q from Quiz q", Quiz.class);
        List<Quiz> quizList = typedQuery.getResultList();
        return quizList.size();
//        entityManager.close();
//        emFactory.close();
    }

    public List<Quiz> getNameOfQuizes() {
        TypedQuery<Quiz> typedQuery = entityManager.createQuery(
                "select q.title from Quiz q", Quiz.class);
        return typedQuery.getResultList();
//        entityManager.close();
//        emFactory.close();
    }

    public List<Quiz> getQuizes() {
        TypedQuery<Quiz> typedQuery = entityManager.createQuery(
                "select q from Quiz q", Quiz.class);
        return typedQuery.getResultList();
//        entityManager.close();
//        emFactory.close();
    }
}
