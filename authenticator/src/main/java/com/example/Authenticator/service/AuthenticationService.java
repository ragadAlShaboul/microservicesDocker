package com.example.Authenticator.service;


import com.example.Authenticator.dao.UserDao;
import com.example.Authenticator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserDao dao  ;
    public boolean userExists(String username , String password){
      return dao.userExists(username,password);
    }
}