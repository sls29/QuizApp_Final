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
        TypedQuery<Question> typedQuery = entityManager.createQuery(
                "select q from Question q", Question.class);
        List<Question> questionList = typedQuery.getResultList();
        return questionList.size();
//        entityManager.close();
//        emFactory.close();
    }

    public List<Question> getQuestions(Integer quiz_id) {
        TypedQuery<Question> typedQuery = entityManager.createQuery(
                "select q from Question q where id=:id", Question.class);
        typedQuery.setParameter("id", 1);
        return typedQuery.getResultList();

//        entityManager.close();
//        emFactory.close();
    }

    public List<Question> getQuizQuestions(int quiz_id) {
        TypedQuery<Question> typedQuery = entityManager.createQuery(
                "select q from Question q join fetch q.quiz where q.id=:id", Question.class);
        typedQuery.setParameter("id", quiz_id);
        return typedQuery.getResultList();

//        entityManager.close();
//        emFactory.close();
    }
}