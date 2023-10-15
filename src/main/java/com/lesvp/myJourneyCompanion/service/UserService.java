package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.model.user.User;
import com.lesvp.myJourneyCompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    // use BCryptPasswordEncoder to hash a password to not stock it as a plain text
    public static String hashPassword(String password) {
        int strength = 10;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(strength, new SecureRandom());

        return bCryptPasswordEncoder.encode(password);
    }

    // to match the password in the database and the password give by the user
    public static boolean matchPasswords(User user, String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(password, user.getHashed_password());
    }
}
