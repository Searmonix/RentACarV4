package com.example.RentACarV3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RentACarV3.Repository.CrudRepository.ScoreCrudRepository;
import com.example.RentACarV3.Model.Score;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    // Get
    public List<Score> findAll() {
        return (List<Score>) scoreCrudRepository.findAll();
    }

     // Get by Id
     public Optional<Score> getScore(int id) {
        return scoreCrudRepository.findById(id);
    }
    
    // Save (Post)
    public Score save(Score score) {
        return scoreCrudRepository.save(score);
    }

    // Delete
    public void delete(Score score) {
        scoreCrudRepository.delete(score);
    }
}
