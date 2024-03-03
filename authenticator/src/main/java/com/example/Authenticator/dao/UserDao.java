package com.example.Authenticator.dao;

import com.example.Authenticator.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public boolean userExists(String username,String password){
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";

        try {
            Integer count = jdbcTemplate.queryForObject(sql, Integer.class, username, password);
            return count != null && count > 0;
        } catch (Exception e) {
            throw new IllegalArgumentException("Error checking user existence", e);
        }
    }
}