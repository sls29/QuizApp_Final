package com.QuizApp.servlet;

import com.QuizApp.repository.JpaQuestionRepository;
import com.QuizApp.repository.JpaQuizRepository;
import com.QuizApp.service.QuestionService;
import com.QuizApp.service.QuizService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/take-api")
public class TakeApiServlet extends HttpServlet {

        private final QuestionService questionService = new QuestionService(new JpaQuestionRepository());
        private final QuizService quizService = new QuizService(new JpaQuizRepository());

        int numberOfQuestions = questionService.getNumberOfQuestions();

        protected void doPost (HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            RequestDispatcher rd = getServletContext().getRequestDispatcher("/take.jsp");
            rd.include(req, resp);
        }
    }