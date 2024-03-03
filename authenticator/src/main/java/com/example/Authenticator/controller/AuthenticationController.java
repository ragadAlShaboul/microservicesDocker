package com.example.Authenticator.controller;

import com.example.Authenticator.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    @Autowired
    private AuthenticationService authenticationService ;
    @PostMapping("/authenticate")
    public String handlingData(@RequestBody String userFields){
        String[] userData=userFields.split(",");
        if(userData.length<2)
            return "invalid user!!";
        String username = userData[0];
        String password = userData[1];

        if (authenticationService.userExists(username,password))
            return "valid";
        else return "invalid user!!";
    }

}