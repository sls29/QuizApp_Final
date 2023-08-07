package com.QuizApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Entity
@Table(name = "quiz")
@NoArgsConstructor

public class Quiz {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String summary;
    private String type;
    private int score;

        @ManyToMany(mappedBy = "quizSet")
    private Set<Question> questions;

    public Quiz(String title, String summary, String type, int score) {
        this.title = title;
        this.summary = summary;
        this.type = type;
        this.score = score;
    }

    public String getQuestionsAsCsv() {
        return getQuestions()
                .stream()
                .map(Question::getName)
                .collect(Collectors.joining(", "));
    }

}
