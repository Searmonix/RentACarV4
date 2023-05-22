package com.example.RentACarV3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RentACarV3.Repository.CrudRepository.GamaCrudRepository;
import com.example.RentACarV3.Model.Gama;

@Repository
public class GamaRepository {
    @Autowired
    private GamaCrudRepository gamaCrudRepository;

    // Get
    public List<Gama> findAll() {
        return (List<Gama>) gamaCrudRepository.findAll();
    }

    // Get by Id
    public Optional<Gama> getGama(int id) {
        return gamaCrudRepository.findById(id);
    }
    
    // Save (Post)
    public Gama save(Gama gama) {
        return gamaCrudRepository.save(gama);
    }

    // Delete
    public void delete(Gama gama) {
        gamaCrudRepository.delete(gama);
    }
}
