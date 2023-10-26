package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.model.Quiz;
import com.lesvp.myJourneyCompanion.model.User;
import com.lesvp.myJourneyCompanion.repository.QuizRepository;
import com.lesvp.myJourneyCompanion.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    /*
    public Quiz createQuiz(String quizTitle, UUID uuidAuthor) {
        Quiz quiz = new Quiz(quizTitle);

        // Set the game and author using the provided UUIDs
        //Game game = gameRepository.findByUuid(uuidGame);
        var author = userRepository.findById(uuidAuthor);

        if (author.isPresent()) {
            quiz.setAuthor(author.get());
            quizRepository.save(quiz);
            return quiz;
        } else {
            return null; // Handle case where game or author with provided UUIDs doesn't exist
        }
    }
*/
}
