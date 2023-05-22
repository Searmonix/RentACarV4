package com.example.RentACarV3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RentACarV3.Repository.CrudRepository.ReservationCrudRepository;
import com.example.RentACarV3.Model.Reservation;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    // Get
    public List<Reservation> findAll() {
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

     // Get by Id
     public Optional<Reservation> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }
    
    // Save (Post)
    public Reservation save(Reservation reservation) {
        return reservationCrudRepository.save(reservation);
    }

    // Delete
    public void delete(Reservation reservation) {
        reservationCrudRepository.delete(reservation);
    }
}
