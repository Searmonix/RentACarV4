package com.example.RentACarV3.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentACarV3.Repository.GamaRepository;
import com.example.RentACarV3.Model.Gama;

@Service
public class GamaServices {
    @Autowired
    private GamaRepository gamaRepository;

    public List<Gama> getAll() {
        return gamaRepository.findAll();
    } 

    public Optional<Gama> getGama(int id) {
        return gamaRepository.getGama(id);
    }

    public Gama save (Gama gama) {
        if (gama.getIdGama() == null) {
            return gamaRepository.save(gama);
        } else {
            Optional<Gama> gamaOptional = getGama(gama.getIdGama());
            if (gamaOptional.isEmpty()) {
                return gamaRepository.save(gama);
            } else {
                return gama;
            }
        }
    }

    public Gama update(Gama gama) {
        if (gama.getIdGama() != null) {
            Optional<Gama> gamaToUpdate = getGama(gama.getIdGama());
            if (gamaToUpdate.isPresent()) {

                if (gama.getName() != null) {
                    gamaToUpdate.get().setName(gama.getName());
                }

                if (gama.getDescription() != null) {
                    gamaToUpdate.get().setDescription(gama.getDescription());
                }

                gamaRepository.save(gamaToUpdate.get());
                return gamaToUpdate.get();

            } else {
                return gama;
            }
        } else {
            return gama;
        }
    }

    public boolean deleteGama(int id) {
        boolean dataStatus = false;
        Optional<Gama> elementToDelete = gamaRepository.getGama(id);
        if (elementToDelete.isPresent()) {
            gamaRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    }
}