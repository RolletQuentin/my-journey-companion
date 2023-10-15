package com.lesvp.myJourneyCompanion.model.user;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue
    private UUID uuid;

    private String username;

    private String email;

    private String hashed_password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    public User() {}

    public User(String username, String email, String hashed_password, List<String> roles) {
        this.username = username;
        this.email = email;
        this.hashed_password = hashed_password;
        this.roles = roles;
    }
}
