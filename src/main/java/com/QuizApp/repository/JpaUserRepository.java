package com.QuizApp.repository;

import com.QuizApp.model.User;
import jakarta.persistence.*;

import java.util.List;
public class JpaUserRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
    EntityManager entityManager = emFactory.createEntityManager();

    public void userRegistration(User user){
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
