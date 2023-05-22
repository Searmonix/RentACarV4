package com.example.RentACarV3.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentACarV3.Repository.ReservationRepository;
import com.example.RentACarV3.Model.Reservation;

@Service
public class ReservationServices {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    } 

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save (Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> reservationOptional = getReservation(reservation.getIdReservation());
            if (reservationOptional.isEmpty()) {
                return reservationRepository.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> reservationToUpdate = getReservation(reservation.getIdReservation());
            if (reservationToUpdate.isPresent()) {

                if (reservation.getStartDate() != null) {
                    reservationToUpdate.get().setStartDate(reservation.getStartDate());
                }

                if (reservation.getDevolutionDate() != null) {
                    reservationToUpdate.get().setDevolutionDate(reservation.getDevolutionDate());
                }

                if (reservation.getStatus() != null) {
                    reservationToUpdate.get().setStatus(reservation.getStatus());
                }

                reservationRepository.save(reservationToUpdate.get());
                return reservationToUpdate.get();

            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    public boolean deleteReservation(int id) {
        boolean dataStatus = false;
        Optional<Reservation> elementToDelete = reservationRepository.getReservation(id);
        if (elementToDelete.isPresent()) {
            reservationRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    }
}