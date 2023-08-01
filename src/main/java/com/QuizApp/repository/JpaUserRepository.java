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
//        entityManager.close();
    }

    public void findAndDeleteUserByEmail(String email){
        TypedQuery<User> typesQuery = entityManager.createQuery("select u from User u WHERE u.email=:email", User.class);
        typesQuery.setParameter("email", email);
        entityManager.getTransaction().begin();
        entityManager.remove(typesQuery.getSingleResult());
        entityManager.flush();
        entityManager.getTransaction().commit();
//        entityManager.close();
    }

    public void updateLastLoginDate(String email, String loginTime){
        TypedQuery<User> typedQuery = entityManager.createQuery("update User u set u.lastlogin =:logintime where u.email=:email", User.class);
        typedQuery.setParameter("logintime", loginTime);
        typedQuery.setParameter("email", email);
        entityManager.getTransaction().begin();
        entityManager.merge(loginTime);
        entityManager.getTransaction().commit();
    }

    public List<User> getAllUsers () {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u", User.class);
        List<User> userList = typedQuery.getResultList();
//        entityManager.close();
        emFactory.close();
        return userList;
    }
}
