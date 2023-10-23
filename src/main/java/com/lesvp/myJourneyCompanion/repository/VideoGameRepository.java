package com.lesvp.myJourneyCompanion.repository;

import com.lesvp.myJourneyCompanion.model.user.VideoGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VideoGameRepository extends JpaRepository<VideoGame, UUID> {
    public VideoGame findByUuid(UUID uuid);
    public VideoGame findByName(String name);
}
