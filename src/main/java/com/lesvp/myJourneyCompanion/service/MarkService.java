package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.model.Mark;
import com.lesvp.myJourneyCompanion.model.User;
import com.lesvp.myJourneyCompanion.model.VideoGame;
import com.lesvp.myJourneyCompanion.repository.MarkRepository;
import com.lesvp.myJourneyCompanion.repository.QuizRepository;
import com.lesvp.myJourneyCompanion.repository.UserRepository;
import com.lesvp.myJourneyCompanion.repository.VideoGameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MarkService {

    @Autowired
    private MarkRepository markRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VideoGameRepository videoGameRepository;


    public Mark createMark(double givenMark, UUID uuidVideoGame, UUID uuidAuthor){
        Mark mark = new Mark(givenMark);

        var videoGame = videoGameRepository.findById(uuidVideoGame);
        var author = userRepository.findById(uuidAuthor);

        if (author.isPresent() && videoGame.isPresent()) {
            mark.setLinkedVideoGame(videoGame.get());
            mark.setLinkedUser(author.get());
            markRepository.save(mark);
            return mark;
        } else {
            return null; // Handle case where game or author with provided UUIDs doesn't exist
        }


    }
}
