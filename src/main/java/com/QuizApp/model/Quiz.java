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

    public Quiz(String title, String summary, String type, int score) {
        this.title = title;
        this.summary = summary;
        this.type = type;
        this.score = score;
    }
}
