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
    private UUID uuid;

    private String quizTitle;

    private String uuidGame;

    /*
    @ManyToOne
    @JoinColumn(name = "uuidGame", referencedColumnName = "uuidGame")
    private Game uuidGame;
    */

    @ManyToOne
    @JoinColumn(name = "uuidAuthor", referencedColumnName = "uuidUser")
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