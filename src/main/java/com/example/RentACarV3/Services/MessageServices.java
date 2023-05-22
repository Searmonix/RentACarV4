package com.example.RentACarV3.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentACarV3.Repository.MessageRepository;
import com.example.RentACarV3.Model.Message;

@Service
public class MessageServices {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll() {
        return messageRepository.findAll();
    } 

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save (Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> messageOptional = getMessage(message.getIdMessage());
            if (messageOptional.isEmpty()) {
                return messageRepository.save(message);
            } else {
                return message;
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> messageToUpdate = getMessage(message.getIdMessage());
            if (messageToUpdate.isPresent()) {

                if (message.getMessageText() != null) {
                    messageToUpdate.get().setMessageText(message.getMessageText());
                }

                messageRepository.save(messageToUpdate.get());
                return messageToUpdate.get();

            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean deleteMessage(int id) {
        boolean dataStatus = false;
        Optional<Message> elementToDelete = messageRepository.getMessage(id);
        if (elementToDelete.isPresent()) {
            messageRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    }
}