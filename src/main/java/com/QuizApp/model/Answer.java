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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int active;
    private int correct;
    private String content;
//    @ManyToOne(targetEntity = Question.class)
//    @JoinColumn(name="id", nullable = false)
    public int question_id;


    public Answer(int active, int correct, String content, int question_id) {
        this.active = active;
        this.correct = correct;
        this.content = content;
        this.question_id = question_id;

    }
}
