package com.example.Results.webapp.controller;

//import com.example.Results.webapp.Login.service.LoginService;
import com.example.Results.webapp.data.entity.Electives;
import com.example.Results.webapp.data.model.ResultsModel;
import com.example.Results.webapp.service.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ResultsController {
	private final ResultsService resultsService;

	@Autowired
	public ResultsController(ResultsService resultsService) {
		this.resultsService = resultsService;
	}
	@GetMapping("/")
	public String showLoginPage() {
//		model.addAttribute("model",new ResultsModel("",new ArrayList<>(),""));
		return "login";
	}

	@GetMapping("/login")
	public String loginUser(@RequestParam("name") String name,
							@RequestParam("password") String password) throws IOException, URISyntaxException, InterruptedException {
		resultsService.checkAnalysis();
		String message= resultsService.checkAuthentication(name,password);
		List<Electives> electives = resultsService.findAllMongo();
		if(!resultsService.checkAnalysis()){
			message="no results yet!";
//			model.addAttribute("model",new ResultsModel(name,electives,message));
			return "no results yet!";
		}
//		model.addAttribute("model",new ResultsModel(name,electives,message));
		if (!message.equals("valid")){
			return "login";
		}
		StringBuilder s= new StringBuilder();
		for(Electives e:electives){
			s.append("\n").append(e.getName()).append(": ").append(e.getVotes());
		}
		return s.toString();
	}
}
