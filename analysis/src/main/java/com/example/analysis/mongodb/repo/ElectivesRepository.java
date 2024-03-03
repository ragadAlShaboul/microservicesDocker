package com.example.analysis.mongodb.repo;


import com.example.analysis.mongodb.entity.Electives;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ElectivesRepository extends MongoRepository<Electives, String> {

}
