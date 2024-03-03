package com.example.DataEntry.webapp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImp implements UserDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void insertData(String username, String data) {
        jdbcTemplate.update("UPDATE users SET data = ? WHERE username = ?;",data , username);
    }
}
