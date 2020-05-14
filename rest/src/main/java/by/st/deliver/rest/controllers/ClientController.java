package by.st.deliver.rest.controllers;


import by.st.deliver.core.dao.ClientRepository;
import by.st.deliver.core.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/user/all")
    public List<Client> allClients() {
        return clientRepository.findAll();
    }
}