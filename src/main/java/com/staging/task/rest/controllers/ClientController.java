package com.staging.task.rest.controllers;


import com.staging.task.core.dao.ClientRepository;
import com.staging.task.core.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/user/all")
    public List<Client> allClients() {
        return clientRepository.findAll();
    }
}