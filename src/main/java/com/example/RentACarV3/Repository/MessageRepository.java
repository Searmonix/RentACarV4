package com.example.RentACarV3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.RentACarV3.Repository.CrudRepository.MessageCrudRepository;
import com.example.RentACarV3.Model.Message;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;

    // Get
    public List<Message> findAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

     // Get by Id
     public Optional<Message> getMessage(int id) {
        return messageCrudRepository.findById(id);
    }
    
    // Save (Post)
    public Message save(Message message) {
        return messageCrudRepository.save(message);
    }

    // Delete
    public void delete(Message message) {
        messageCrudRepository.delete(message);
    }
}
