package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.model.Question;
import com.lesvp.myJourneyCompanion.model.Quiz;
import com.lesvp.myJourneyCompanion.repository.QuizRepository;
import com.lesvp.myJourneyCompanion.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    public void createQuestion(String questionTitle, UUID uuidQuiz) {
        // Récupérez le quiz correspondant à uuidQuiz
        var quizOptional = quizRepository.findById(uuidQuiz);
        if (quizOptional.isPresent()) {
            questionRepository.save(
                    new Question(questionTitle, quizOptional.get())
            );
        } else {
            throw new NoSuchElementException("No value present");
        }
    }
}

