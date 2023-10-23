package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.model.user.VideoGame;
import com.lesvp.myJourneyCompanion.repository.VideoGameRepository;
import com.lesvp.myJourneyCompanion.security.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.UUID;

@Service
public class VideoGameService {

    private final VideoGameRepository videoGameRepository;

    public VideoGameService(VideoGameRepository videoGameRepository) {
        this.videoGameRepository = videoGameRepository;
    }

    public VideoGame createVideoGame(VideoGame videoGame){
        return videoGameRepository.save(videoGame);
    }

    public VideoGame getVideoGameByName(String name){
        return videoGameRepository.findByName(name);
    }

    public VideoGame getVideoGame(UUID uuid){
        return videoGameRepository.findByUuid(uuid);
    }

    public List<VideoGame> getVideoGames(){
        return videoGameRepository.findAll();
    }

    public void delete(UUID uuid){
        VideoGame videoGame = getVideoGame(uuid);
        videoGameRepository.delete(videoGame);
    }

    public VideoGame update(UUID uuid, int mark){
        VideoGame existingVideoGame = getVideoGame(uuid);
        existingVideoGame.setMark(mark);

        return videoGameRepository.save(existingVideoGame);
    }

}
