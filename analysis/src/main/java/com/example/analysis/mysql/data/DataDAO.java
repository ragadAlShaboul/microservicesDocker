package com.example.analysis.mysql.data;

import java.util.List;
import java.util.Map;

public interface DataDAO {
    List<String> getAllData();
    Map<String,Integer> electiveData();
}
