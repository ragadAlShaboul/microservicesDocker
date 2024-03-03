package com.example.DataEntry.webapp.controller;

import com.example.DataEntry.webapp.service.DataEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


import java.io.IOException;
import java.net.URISyntaxException;

@RestController
public class DataEntryController {
	@Autowired
	private DataEntryService dataEntryService;

	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/login")
	public String loginUser(@RequestParam("name") String name,
							@RequestParam("password") String password
							) throws URISyntaxException, IOException, InterruptedException {
		String message= dataEntryService.checkAuthentication(name,password);
//		model.addAttribute("name",name);
		if (!message.equals("valid")){
//			model.addAttribute("message" , message);
			return "login";
		}
		return "enter data";
	}
	@GetMapping("/submit")
	public String submitVote(@RequestParam("hidden") String name,
							 @RequestParam("data") String data) {
		dataEntryService.insertData(name,data);
		return "Thanks";
	}
}
