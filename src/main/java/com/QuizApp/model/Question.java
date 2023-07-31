package com.QuizApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
    @OneToMany (mappedBy = "questions")
    private Set<Answer> answers;

    private int id;
    private String name;
    private String type;
    private int active;
    private int level;
    private int score;
    private String content;


    public Question( String name, String type, int active, int level, int score, String content){
        this.name = name;
        this.type = type;
        this.active = active;
        this.level = level;
        this.score = score;
        this.content = content;
    }
}
