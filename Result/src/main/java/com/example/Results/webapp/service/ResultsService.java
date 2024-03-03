package com.example.Results.webapp.service;

import com.example.Results.webapp.data.entity.Electives;
import com.example.Results.webapp.data.repo.ElectivesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class ResultsService {
    private ElectivesRepository electivesRepository;
    @Autowired
    public ResultsService(ElectivesRepository electivesRepository){
        this.electivesRepository=electivesRepository;
    }
    public List<Electives> getTopThreeByVotes() {
        return electivesRepository.findTop3ByOrderByVotesDesc();
    }
    public String checkAuthentication(String username, String password) throws IOException, InterruptedException, URISyntaxException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =HttpRequest.newBuilder()
                .uri(new URI("http://authenticator:8080/authenticate"))
                .POST(HttpRequest.BodyPublishers.ofString(username+","+password))
                .build();
        HttpResponse<String> response=client.send(request , HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public List<Electives> findAllMongo(){
        return electivesRepository.findAll();
    }
    public boolean checkAnalysis() throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =HttpRequest.newBuilder()
                .uri(new URI("http://analysis:8080/analysis"))
                .POST(HttpRequest.BodyPublishers.ofString("doAnalysis"))
                .build();
        HttpResponse<String> response=client.send(request , HttpResponse.BodyHandlers.ofString());
        return !response.body().equals("incomplete");
    }
   }
