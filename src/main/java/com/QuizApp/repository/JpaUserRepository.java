package com.QuizApp.repository;

import com.QuizApp.model.User;
import jakarta.persistence.*;

import java.util.List;


public class JpaUserRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");
    EntityManager entityManager = emFactory.createEntityManager();

    public void userRegistration(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<User> getAllUsers () {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u", User.class);
        List<User> userList = typedQuery.getResultList();
        entityManager.close();
        emFactory.close();
        return userList;
    }
}
