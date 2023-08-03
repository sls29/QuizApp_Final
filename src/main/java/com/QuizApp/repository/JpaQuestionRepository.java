package com.QuizApp.repository;

import com.QuizApp.model.Answer;
import com.QuizApp.model.Question;
import com.QuizApp.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.LinkedList;
import java.util.List;

public class JpaQuestionRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");
    EntityManager entityManager = emFactory.createEntityManager();

    public void questionImport(Question question) {
        entityManager.getTransaction().begin();
        entityManager.persist(question);
        entityManager.getTransaction().commit();
    }
    //        entityManager.close();

    public int getNumberOfQuestions() {
        TypedQuery<Question> typedQuery = entityManager.createQuery("select q from Question q", Question.class);
        List<Question> questionList = typedQuery.getResultList();
        return questionList.size();
//        entityManager.close();
//        emFactory.close();

    }
}