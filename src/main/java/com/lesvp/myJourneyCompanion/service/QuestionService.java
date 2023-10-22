package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.model.Question;
import com.lesvp.myJourneyCompanion.model.Quiz;
import com.lesvp.myJourneyCompanion.repository.QuizRepository;
import com.lesvp.myJourneyCompanion.repository.QuestionRepository;

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
        Quiz quiz = quizRepository.findByUuid(uuidQuiz);

        if (quiz != null) {
            // Créez une nouvelle question et associez-la au quiz
            Question question = new Question(questionTitle, quiz);
            //questionRepository.save(question);
        } else {
            // Gérez le cas où le quiz n'a pas été trouvé
        }
    }
}

