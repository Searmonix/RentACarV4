package com.example.RentACarV3.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentACarV3.Repository.ScoreRepository;
import com.example.RentACarV3.Model.Score;

@Service
public class ScoreServices {
    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll() {
        return scoreRepository.findAll();
    } 

    public Optional<Score> getScore(int id) {
        return scoreRepository.getScore(id);
    }

    public Score save (Score score) {
        if (score.getIdScore() == null) {
            return scoreRepository.save(score);
        } else {
            Optional<Score> scoreOptional = getScore(score.getIdScore());
            if (scoreOptional.isEmpty()) {
                return scoreRepository.save(score);
            } else {
                return score;
            }
        }
    }

    public Score update(Score score) {
        if (score.getIdScore() != null) {
            Optional<Score> scoreToUpdate = getScore(score.getIdScore());
            if (scoreToUpdate.isPresent()) {

                if (score.getStars() != null) {
                    scoreToUpdate.get().setStars(score.getStars());
                }
                if (score.getMessageText() != null) {
                    scoreToUpdate.get().setMessageText(score.getMessageText());
                }

                scoreRepository.save(scoreToUpdate.get());
                return scoreToUpdate.get();

            } else {
                return score;
            }
        } else {
            return score;
        }
    }

    public boolean deleteScore(int id) {
        boolean dataStatus = false;
        Optional<Score> elementToDelete = scoreRepository.getScore(id);
        if (elementToDelete.isPresent()) {
            scoreRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    }
}