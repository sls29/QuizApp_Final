package com.QuizApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "quiz_questions",
        joinColumns = {@JoinColumn(name = "quiz_id")},
        inverseJoinColumns = {@JoinColumn(name = "question_id")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Question> questions;

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
