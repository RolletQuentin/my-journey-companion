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

    public Quiz(String quizTitle, List<Question> questions, VideoGame game, User author) {

        this.quizTitle = quizTitle;
        this.questions = questions;
        this.game = game;
        this.author = author;
    }

}