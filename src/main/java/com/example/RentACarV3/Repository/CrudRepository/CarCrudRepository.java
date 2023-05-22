package com.example.RentACarV3.Repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.RentACarV3.Model.Car;

public interface CarCrudRepository extends CrudRepository<Car, Integer> {
    
}
