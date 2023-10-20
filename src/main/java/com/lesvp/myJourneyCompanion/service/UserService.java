package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.model.User;
import com.lesvp.myJourneyCompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(UUID uuid) {
        Optional<User> userOptional = userRepository.findById(uuid);
        User user;

        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            throw new RuntimeException("User not found");
        }

        return user;
    }

    public List<User> getUsers() { return userRepository.findAll(); }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User update(UUID uuid, String username, String email) {
        User existingUser = getUser(uuid);

        existingUser.setUsername(username);
        existingUser.setEmail(email);

        return userRepository.save(existingUser);
    }

    public void delete(UUID uuid) {
        User user = getUser(uuid);
        userRepository.delete(user);
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
