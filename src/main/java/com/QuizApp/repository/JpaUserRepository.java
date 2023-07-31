package com.QuizApp.repository;

import com.QuizApp.model.User;
import jakarta.persistence.*;

import java.util.List;


public class JpaUserRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");


    public void userRegistration(User user){
        EntityManager entityManager = emFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void findAndDeleteUserByEmail(String email){
        EntityManager entityManager = emFactory.createEntityManager();
        TypedQuery<User> typesQuery = entityManager.createQuery("select u from User u WHERE u.email=:email", User.class);
        typesQuery.setParameter("email", email);
        entityManager.getTransaction().begin();
        entityManager.remove(typesQuery.getSingleResult());
        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<User> getAllUsers () {
        EntityManager entityManager = emFactory.createEntityManager();
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u", User.class);
        List<User> userList = typedQuery.getResultList();
        entityManager.close();
        emFactory.close();
        return userList;
    }
}
