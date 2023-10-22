package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.model.user.User;
import com.lesvp.myJourneyCompanion.repository.QuizRepository;
import com.lesvp.myJourneyCompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

}
