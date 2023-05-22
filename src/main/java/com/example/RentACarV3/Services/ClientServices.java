package com.example.RentACarV3.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RentACarV3.Repository.ClientRepository;
import com.example.RentACarV3.Model.Client;

@Service
public class ClientServices {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll() {
        return clientRepository.findAll();
    } 

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    public Client save (Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> clientOptional = getClient(client.getIdClient());
            if (clientOptional.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }
    }

    public Client update(Client client) {
        if (client.getIdClient() != null) {
            Optional<Client> clientToUpdate = getClient(client.getIdClient());
            if (clientToUpdate.isPresent()) {

                if (client.getEmail() != null) {
                    clientToUpdate.get().setEmail(client.getEmail());
                }

                if (client.getPassword() != null) {
                    clientToUpdate.get().setPassword(client.getPassword());
                }

                if (client.getName() != null) {
                    clientToUpdate.get().setName(client.getName());
                }

                if (client.getAge() != null) {
                    clientToUpdate.get().setAge(client.getAge());
                }

                clientRepository.save(clientToUpdate.get());
                return clientToUpdate.get();

            } else {
                return client;
            }
        } else {
            return client;
        }
    }

    public boolean deleteClient(int id) {
        boolean dataStatus = false;
        Optional<Client> elementToDelete = clientRepository.getClient(id);
        if (elementToDelete.isPresent()) {
            clientRepository.delete(elementToDelete.get());
            dataStatus = true;
        }
        return dataStatus;
    }
}