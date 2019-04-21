package com.example.demo.service.impl;

import com.example.demo.domain.Client;
import com.example.demo.domain.ClientRepository;
import com.example.demo.exception.ClientNotFoundException;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientRepository ur;

    @Override
    public void addClient(Client client) {
        ur.save(client);
    }

    @Override
    public void deleteClient(Client client) {
        ur.delete(client);
    }

    @Override
    public Client getClientById(long id) {
        Client client = ur.findClient(id);
        if (Objects.isNull(client))
            throw new ClientNotFoundException("該用戶不存在");

        return client;
    }

    @Override
    public List<Client> getAllClient() {
        return ur.findAll();
    }
}
