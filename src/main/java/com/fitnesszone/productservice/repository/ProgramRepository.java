package com.fitnesszone.productservice.repository;

import com.fitnesszone.productservice.model.Program;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramRepository extends MongoRepository<Program, String> {
    List<Program> findByActiveTrue();
    List<Program> findByDurationInMonths(int durationInMonths);
}
