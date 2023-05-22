package com.example.RentACarV3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RentACarV3.Repository.CrudRepository.CarCrudRepository;
import com.example.RentACarV3.Model.Car;

@Repository
public class CarRepository {
    @Autowired
    private CarCrudRepository carCrudRepository;

    // Get
    public List<Car> findAll() {
        return (List<Car>) carCrudRepository.findAll();
    }

    // Get by Id
    public Optional<Car> getCar(int id) {
        return carCrudRepository.findById(id);
    }
    
    // Save (Post)
    public Car save(Car car) {
        return carCrudRepository.save(car);
    }

    // Delete
    public void delete(Car car) {
        carCrudRepository.delete(car);
    }
}
