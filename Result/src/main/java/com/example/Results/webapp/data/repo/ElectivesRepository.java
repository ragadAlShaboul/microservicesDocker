package com.example.Results.webapp.data.repo;


import com.example.Results.webapp.data.entity.Electives;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ElectivesRepository extends MongoRepository<Electives, String> {
    List<Electives> findTop3ByOrderByVotesDesc();
}
