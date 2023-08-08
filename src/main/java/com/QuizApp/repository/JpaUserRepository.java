package com.QuizApp.repository;

import com.QuizApp.model.Question;
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
        TypedQuery<User> typesQuery = entityManager.createQuery(
                "select u from User u WHERE u.email=:email", User.class);
        typesQuery.setParameter("email", email);
        entityManager.getTransaction().begin();
        entityManager.remove(typesQuery.getSingleResult());
        entityManager.flush();
        entityManager.getTransaction().commit();
//        entityManager.close();
    }

    public void updateLastLoginDate(String email, String loginTime){
        TypedQuery<User> typedQuery = entityManager.createQuery(
                "select u from User u where email=:email", User.class);
        typedQuery.setParameter("email", email);
        User user = typedQuery.getSingleResult();
        entityManager.getTransaction().begin();
        user.setLastLogin(loginTime);
        entityManager.getTransaction().commit();
//        entityManager.close();
    }

    public boolean findUser(String email){
        TypedQuery<User> typedQuery = entityManager.createQuery(
                "select u from User u where email=:email", User.class);
        typedQuery.setParameter("email", email);
        User user = typedQuery.getSingleResult();
        return true;
//        entityManager.close();
    }

    public List<User> getAllUsers () {
        TypedQuery<User> typedQuery = entityManager.createQuery("select u from User u", User.class);
        return typedQuery.getResultList();

//        entityManager.close();
//        emFactory.close();

    }
    public int getNumberOfUsers() {
        TypedQuery<User> typedQuery = entityManager.createQuery(
                "select u from User u", User.class);
        List<User> questionList = typedQuery.getResultList();
        return questionList.size();
//        entityManager.close();
//        emFactory.close();
    }
}
