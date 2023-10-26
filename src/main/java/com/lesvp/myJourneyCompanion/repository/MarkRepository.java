package com.lesvp.myJourneyCompanion.repository;

import com.lesvp.myJourneyCompanion.model.Mark;
import com.lesvp.myJourneyCompanion.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarkRepository extends JpaRepository<Mark, UUID> {
}
