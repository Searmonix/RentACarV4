package com.example.RentACarV3.Repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.RentACarV3.Model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}
