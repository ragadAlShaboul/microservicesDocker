package com.example.analysis.mysql.data;

import com.example.analysis.mongodb.entity.Electives;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class DataDAOImp implements DataDAO{
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public DataDAOImp(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    @Override
    public List<String> getAllData() {
        List<String> data;
        String sql ="SELECT data FROM users;";
        try {
            data = jdbcTemplate.query(sql,  (resultSet, i) -> {
                return resultSet.getString("data");
            });
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving teacher classes", e);
        }
        return data;
    }
    public Map<String,Integer> electiveData(){
        String sqlQuery = "SELECT data, COUNT(*) as count FROM users WHERE data IS NOT NULL GROUP BY data";

        return jdbcTemplate.query(sqlQuery, new RowMapper<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                String dataColumn = resultSet.getString("data");
                int count = resultSet.getInt("count");
                Map<String, Integer> resultMap = new HashMap<>();
                resultMap.put(dataColumn, count);
                return resultMap;
            }
        }).stream().reduce(new HashMap<>(), (resultMap, entry) -> {
            resultMap.putAll(entry);
            return resultMap;
        });
    }

}
