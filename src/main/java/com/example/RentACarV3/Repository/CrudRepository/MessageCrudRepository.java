package com.example.RentACarV3.Repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;

import com.example.RentACarV3.Model.Message;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
    
}
