package com.QuizApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table (name = "answers")
@NoArgsConstructor

public class Answer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int active;
    private int correct;
    private String content;
@ManyToOne(fetch = FetchType.LAZY)
    private Question Question;



    public Answer (int active, int correct, String content, Question Question) {
        this.active = active;
        this.correct = correct;
        this.content = content;
        this.Question = Question;

    }

}
