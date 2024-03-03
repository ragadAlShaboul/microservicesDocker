package com.example.analysis.service;

import com.example.analysis.mongodb.entity.Electives;
import com.example.analysis.mongodb.repo.ElectivesRepository;
import com.example.analysis.mysql.data.DataDAOImp;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AnalysisService {
    private DataDAOImp dataDAOImp;
    private ElectivesRepository electivesRepository;
    @Autowired
    public AnalysisService(DataDAOImp dataDAOImp, ElectivesRepository electivesRepository) {
        this.dataDAOImp = dataDAOImp;
        this.electivesRepository = electivesRepository;
    }

    int counter=0;
    public void saveCountToMongo() {
        Map<String, Integer> counts = dataDAOImp.electiveData();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            Electives electives = new Electives();
            electives.setName(entry.getKey());
            electives.setVotes(entry.getValue());
            electivesRepository.save(electives);
        }
    }
}
