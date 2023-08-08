package com.QuizApp.servlet;

import com.QuizApp.model.Quiz;
import com.QuizApp.repository.JpaQuestionRepository;
import com.QuizApp.repository.JpaQuizRepository;
import com.QuizApp.service.QuestionService;
import com.QuizApp.service.QuizService;
import com.QuizApp.model.Question;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebServlet("/startquiz-api")
public class StartQuizApiServlet extends HttpServlet {
    private final QuizService quizService = new QuizService(new JpaQuizRepository());
    private final QuestionService questionService = new QuestionService(new JpaQuestionRepository());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userSelectQuizName = req.getParameter("quizName");
        Quiz quiz = quizService.getQuizId(userSelectQuizName);

//        List<Question> questionsList = questionService.getAllQuizQuestions(quiz.getId());

        RequestDispatcher rd = req.getServletContext().getRequestDispatcher("/take.jsp");
        rd.include(req, resp);
    }
}