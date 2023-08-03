package com.QuizApp.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaQuizRepository {
    EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("com.QuizApp");
    EntityManager entityManager = emFactory.createEntityManager();

}
