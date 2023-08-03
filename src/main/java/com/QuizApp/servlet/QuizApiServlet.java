package com.QuizApp.servlet;

import com.QuizApp.model.Quiz;
import com.QuizApp.repository.JpaQuestionRepository;
import com.QuizApp.repository.JpaQuizRepository;
import com.QuizApp.service.QuestionService;
import com.QuizApp.service.QuizService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/quiz-api")
public class QuizApiServlet extends HttpServlet {

    private final QuestionService questionService = new QuestionService(new JpaQuestionRepository());
    private final QuizService quizService = new QuizService(new JpaQuizRepository()); ;
    int numberOfQuestions = questionService.getNumberOfQuestions();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        String quizName = req.getParameter("quizName");

        Quiz quiz = new Quiz();

        quiz.setTitle(quizName);
        quiz.setType("JAVA");
        quiz.setSummary(null);
        quiz.setScore(1);

        try {
           List questions = quizService.generateNumberQuestions(numberOfQuestions);
        } catch (RuntimeException e) {
                out.println(e.getMessage() + "Questions problem");
            }


    }
}



