package com.QuizApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table (name = "questions")
@NoArgsConstructor

public class Question {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int id;
    private String name;
    private String type;
    private int active;
    private int level;
    private int score;
    private String content;
    @ManyToMany
    private List<Quiz> quizList;


    public Question( String name, String type, int active, int level, int score, String content){
        this.name = name;
        this.type = type;
        this.active = active;
        this.level = level;
        this.score = score;
        this.content = content;
    }
}
