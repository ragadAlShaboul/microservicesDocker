package com.example.analysis.controller;

import com.example.analysis.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AnalysisController {
    @Autowired
    private AnalysisService service;
    @PostMapping("/analysis")
    public String doAnalytics(@RequestBody String command) {
        if (!command.equals("doAnalysis"))
            return "incomplete";
        service.saveCountToMongo();
        return "completed";
    }

}
