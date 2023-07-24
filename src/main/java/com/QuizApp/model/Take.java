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
@Table(name = "takes")
@NoArgsConstructor

public class Take {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int status;
    private int score;
    private String content;
    public Take(int status, int score, String content){
        this.status = status;
        this.score = score;
        this.content = content;
    }


}
