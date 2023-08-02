package com.QuizApp.service;

import com.QuizApp.model.Answer;
import com.QuizApp.model.dto.CreateAnswerDto;
import com.QuizApp.repository.JpaAnswerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class AnswerService {
    private final JpaAnswerRepository jpaAnswerRepository;
    public void addAnswer(CreateAnswerDto createAnswerDto){
//        if (!validateAnswers( answers)) {
//            throw new RuntimeException("Check the answer list for consistence");
//        }
        Answer answer = new Answer();

        answer.setActive(createAnswerDto.getActive());
        answer.setCorrect(createAnswerDto.getCorrect());
        answer.setContent(createAnswerDto.getContent());
        answer.setQuestion_id(createAnswerDto.getQuestion_id());
            jpaAnswerRepository.answerImport(answer);
        }

    private boolean validateAnswers(List<CreateAnswerDto> answers) {
        boolean answerIsOk = answers.stream().anyMatch(Objects::nonNull);

        return answerIsOk;
    }
}