package com.QuizApp.servlet;

import com.QuizApp.model.dto.CreateAnswerDto;
import com.QuizApp.model.dto.CreateQuestionDto;
import com.QuizApp.model.Answer;
import com.QuizApp.repository.JpaQuestionRepository;
import com.QuizApp.service.QuestionService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;


import java.io.*;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/question-api")
public class QuestionApiServlet extends HttpServlet {
    private final QuestionService questionService = new QuestionService(new JpaQuestionRepository());

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String csvFilePath = "/home/think/IdeaProjects/QuizApp_Final/QuizQuestionsCSV.csv";
        BufferedReader lineReader = new BufferedReader(new FileReader(csvFilePath));

            PrintWriter out = resp.getWriter();
            String lineText = null;
            int count = 0;
//            lineReader.readLine(); // skip header line
        LinkedList<CreateAnswerDto> answers = new LinkedList<>();
        CreateQuestionDto questionDto = new CreateQuestionDto();

        while ((lineText = lineReader.readLine()) != null) {
            String[] questions = lineText.split(",");
            String questionName = questions[0];
            String questionType = questions[1];
            int questionLevel = Integer.parseInt(questions[2]);
            String answerOpt0 = questions[3];
            int answerOpt0C = Integer.parseInt(questions[4]);
            String answerOpt1 = questions[5];
            int answerOpt1C = Integer.parseInt(questions[6]);
            String answerOpt2 = questions[7];
            int answerOpt2C = Integer.parseInt(questions[8]);

            questionDto.setName(questionName);
            questionDto.setType(questionType);
            questionDto.setLevel(questionLevel);
            questionDto.setActive(1);
            questionDto.setScore(1);
            questionDto.setContent(null);

            CreateAnswerDto answerDto0 = new CreateAnswerDto();
            answerDto0.setContent(answerOpt0);
            answerDto0.setCorrect(answerOpt0C);
            answerDto0.setActive(1);
            answers.add(answerDto0);

            CreateAnswerDto answerDto1 = new CreateAnswerDto();
            answerDto1.setContent(answerOpt1);
            answerDto1.setCorrect(answerOpt1C);
            answerDto1.setActive(1);
            answers.add(answerDto1);

            CreateAnswerDto answerDto2 = new CreateAnswerDto();
            answerDto2.setContent(answerOpt2);
            answerDto2.setCorrect(answerOpt2C);
            answerDto2.setActive(1);
            answers.add(answerDto2);

            questionService.addQuestion(questionDto, answers);
        }

    lineReader.close();
    RequestDispatcher rs = req.getRequestDispatcher("admin.jsp");
    rs.include(req, resp);
    String val1="Questions loaded.";
    out.println("<!DOCTYPE html><html>");
//    out.println("");
    out.println("<head>");
    out.println("<title>Login Servlet Mesg</title>");
    out.println("</head>");
    out.println("<body onLoad=\"showResult();\">");
    out.println("<script>");
    out.println("function showResult(){");
    out.println("alert(\""+val1+"\")");
    out.println("}");
    out.println("</script></body></html>");
//    out.println("");
//    out.println("");
    }
}
