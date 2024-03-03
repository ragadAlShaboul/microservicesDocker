package com.example.DataEntry.webapp.service;

import com.example.DataEntry.webapp.data.UserDAOImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class DataEntryService {
    @Autowired
    private UserDAOImp userDAOImp;


    public void insertData(String username,String data){
        userDAOImp.insertData(username,data);
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
}
