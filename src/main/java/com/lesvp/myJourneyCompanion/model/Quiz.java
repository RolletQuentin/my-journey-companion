package com.lesvp.myJourneyCompanion.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Quiz {
    @Id
    @GeneratedValue
    private UUID uuidQuiz;

    private String quizTitle;

    @ManyToOne
    @JoinColumn(name = "game", referencedColumnName = "uuid")
    private VideoGame game;

    @ManyToOne
    @JoinColumn(name = "author", referencedColumnName = "uuid")
    private User author;

    @OneToMany
    private List<Question> questions;

    public Quiz() {}

    public Quiz(String quizTitle, VideoGame game, User author, List<Question> questions) {
        this.quizTitle = quizTitle;
        this.game = game;
        this.author = author;
        this.questions = questions;
        // Mettre à jour les références de chaque réponse à cette question
        questions.forEach(question -> {
            question.setQuiz(this);
            question.getAnswers().forEach(answer -> answer.setQuestion(question));
        });
    }



}