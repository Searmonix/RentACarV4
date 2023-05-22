package com.example.RentACarV3.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentACarV3.Repository.CarRepository;
import com.example.RentACarV3.Model.Car;

@Service
public class CarServices {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    } 

    public Optional<Car> getCar(int id) {
        return carRepository.getCar(id);
    }

    public Car save(Car car) {
        if (car.getIdCar() == null) {
            return carRepository.save(car);
        } else {
            Optional<Car> carOptional = getCar(car.getIdCar());
            if (carOptional.isEmpty()) {
                return carRepository.save(car);
            } else {
                return car;
            }
        }
    }

    public Car update(Car car) {
        if (car.getIdCar() != null) {
            Optional<Car> carToUpdate = getCar(car.getIdCar());
            if (carToUpdate.isPresent()) {

                if (car.getName() != null) {
                    carToUpdate.get().setName(car.getName());
                }

                if (car.getBrand() != null) {
                    carToUpdate.get().setBrand(car.getBrand());
                }

                if (car.getYear() != null) {
                    carToUpdate.get().setYear(car.getYear());
                }

                if (car.getDescription() != null) {
                    carToUpdate.get().setDescription(car.getDescription());
                }

                carRepository.save(carToUpdate.get());
                return carToUpdate.get();

            } else {
                return car;
            }
        } else {
            return car;
        }
    }

    public boolean deleteCar(int id) {
        boolean dataStatus = false;
        Optional<Car> elementToDelete = carRepository.getCar(id);
        if (elementToDelete.isPresent()) {
            carRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    }
}
