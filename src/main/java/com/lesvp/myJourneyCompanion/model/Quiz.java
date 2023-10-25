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

    public Quiz() {}


    public Quiz(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    /*
    public Quiz(String quizTitle, Game uuidGame, User uuidAuthor) {
        this.quizTitle = quizTitle;
        this.game = game;
        this.uuidAuthor = uuidAuthor;
    }

     */
    public Quiz(String quizTitle, User author) {
        this.quizTitle = quizTitle;
        this.author = author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


}