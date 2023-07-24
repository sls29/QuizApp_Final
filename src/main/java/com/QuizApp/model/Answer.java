package com.QuizApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table (name = "answers")

public class Answer {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int active;
    private int corect;
    private String content;

    public Answer (int active, int corect, String content) {
        this.active = active;
        this.corect = corect;
        this.content = content;
    }

}
