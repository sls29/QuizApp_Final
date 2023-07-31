package com.QuizApp.servlet;

import com.QuizApp.model.dto.CreateAnswerDto;
import com.QuizApp.model.dto.CreateQuestionDto;
import com.QuizApp.model.Answer;
import com.QuizApp.repository.JpaQuestionRepository;
import com.QuizApp.service.QuestionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/question-api")
public class QuestionApiServlet extends HttpServlet {
    private final QuestionService questionService = new QuestionService(new JpaQuestionRepository());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String csvFilePath = "QuizQuestionsCVS.csv";

            BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));
            String lineText = null;

        int count = 0;

        lineReader.readLine(); // skip header line

        while ((lineText = lineReader.readLine()) != null) {
            String[] questions = lineText.split(",");
            String questionName = questions[0];
            String questionType = questions[1];
            int questionLevel = Integer.parseInt(questions[2]);
            String answerOpt0 = questions[4];
            int answerOpt0C = Integer.parseInt(questions[5]);
            String answerOpt1 = questions[6];
            int answerOpt1C = Integer.parseInt(questions[7]);
            String answerOpt2 = questions[8];
            int answerOpt2C = Integer.parseInt(questions[9]);

            CreateQuestionDto questionDto = new CreateQuestionDto();

            questionDto.setName(questionName);
            questionDto.setType(questionType);
            questionDto.setLevel(questionLevel);
            questionDto.setActive(1);
            questionDto.setScore(1);
            questionDto.setContent(null);

            LinkedList<CreateAnswerDto> answers = new LinkedList<>();
            CreateAnswerDto answerDto0 = new CreateAnswerDto();
            CreateAnswerDto answerDto1  = new CreateAnswerDto();
            CreateAnswerDto answerDto2  = new CreateAnswerDto();

            answerDto0.setContent(answerOpt0);
            answerDto0.setCorrect(answerOpt0C);
            answerDto0.setActive(1);

            answerDto1.setContent(answerOpt1);
            answerDto1.setCorrect(answerOpt1C);
            answerDto1.setActive(1);

            answerDto2.setContent(answerOpt2);
            answerDto2.setCorrect(answerOpt2C);
            answerDto2.setActive(1);

            answers.add(answerDto0);
            answers.add(answerDto1);
            answers.add(answerDto2);

            questionService.addQuestion(questionDto, answers);

         }
    }
}