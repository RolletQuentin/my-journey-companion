package com.lesvp.myJourneyCompanion.service;

import com.lesvp.myJourneyCompanion.security.TokenManager;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class VideoGameService {

    private final String igdbApiBaseUrl = "https://api.igdb.com/v4/games";
    private final String clientId = System.getenv("TWITCH_ID");
    private final String accessToken = TokenManager.getInstance().getToken();

    public String getVideoGames() throws URISyntaxException, IOException, InterruptedException {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Client-ID", clientId);
        headers.set("Authorization", "Bearer " + accessToken);

        HttpClient client = HttpClient.newHttpClient();


        HttpRequest request = HttpRequest.newBuilder()
            .uri(new URI(igdbApiBaseUrl))
            .header("Client-ID", clientId)
            .header("Authorization", "Bearer " + accessToken)
            .POST(HttpRequest.BodyPublishers.noBody())
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
