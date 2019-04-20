package com.example.demo.service;

import com.example.demo.domain.Client;

import java.util.List;

public interface ClientService {
    void addClient(Client client);

    void deleteClient(Client client);

    Client getClientById(long id);

    List<Client> getAllClient();
}
