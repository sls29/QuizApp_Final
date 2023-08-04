package com.QuizApp.repository;

import com.QuizApp.model.Answer;
import com.QuizApp.model.Question;
import com.QuizApp.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class JpaAnswerRepository {

    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");
    EntityManager entityManager = emFactory.createEntityManager();

    public void answerImport(Answer answer) {
        entityManager.getTransaction().begin();
        entityManager.persist(answer);
        entityManager.getTransaction().commit();
    }
    public List<Answer> getAnswers(Integer question_id){
        TypedQuery<Answer> typedQuery = entityManager.createQuery(
                "select a from Answer a where question_id=:question_id", Answer.class);
        typedQuery.setParameter("question_id", 1);
        return typedQuery.getResultList();
    }

//        entityManager.close();

}