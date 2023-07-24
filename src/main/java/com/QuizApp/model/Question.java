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
@Table (name = "questions")
@NoArgsConstructor

public class Question {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String type;
    private int active;
    private int level;
    private int score;
    private String content;

    public Question(String type, String name, int active, int level, int score, String content){
        this.type = type;
        this.name = name;
        this.active = active;
        this.level = level;
        this.score = score;
        this.content = content;
    }
}
