package com.example.DataEntry.webapp.controller;

import com.example.DataEntry.webapp.service.DataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;


import java.io.IOException;
import java.net.URISyntaxException;

@Controller
public class DataEntryController {
	@Autowired
	private DataEntryService dataEntryService;

	@RequestMapping("/")
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping("/login")
	public String loginUser(@RequestParam("name") String name,
							@RequestParam("password") String password,
							Model model
							) throws URISyntaxException, IOException, InterruptedException {
		String message= dataEntryService.checkAuthentication(name,password);
		model.addAttribute("name",name);
		if (!message.equals("valid")){
			model.addAttribute("message" , message);
			return "login";
		}
		return "DataEntry";
	}
	@RequestMapping("/submit")
	public String submitVote(@RequestParam("hidden") String name,
							 @RequestParam("data") String data) {
		dataEntryService.insertData(name,data);
		return "Thanks";
	}
}
