package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.model.Question;
import com.lesvp.myJourneyCompanion.model.Quiz;
import com.lesvp.myJourneyCompanion.repository.QuizRepository;
import com.lesvp.myJourneyCompanion.repository.QuestionRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;

    public QuestionService(QuestionRepository questionRepository, QuizRepository quizRepository) {
        this.questionRepository = questionRepository;
        this.quizRepository = quizRepository;
    }

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

