package com.example.Results.webapp.data.model;

import com.example.Results.webapp.data.entity.Electives;

import java.util.List;

public class ResultsModel {
    String name;
    List<Electives> electives;
    String message;

    public ResultsModel(String name,List<Electives> electives, String message) {
        this.name=name;
        this.electives = electives;
        this.message = message;
    }

    public List<Electives> getElectives() {
        return electives;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
