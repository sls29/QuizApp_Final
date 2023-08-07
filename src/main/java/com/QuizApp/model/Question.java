package com.QuizApp.model;

import jakarta.persistence.*;
import lombok.*;

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
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "quiz_questions",
            joinColumns = {@JoinColumn(name = "question_id")},
            inverseJoinColumns = {@JoinColumn(name = "quiz_id")})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Quiz> quizSet;
//    @OneToMany
//    public List<Answer> answerList;


    public Question( String name, String type, int active, int level, int score, String content){
        this.name = name;
        this.type = type;
        this.active = active;
        this.level = level;
        this.score = score;
        this.content = content;
    }
}
