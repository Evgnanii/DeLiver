package by.st.deliver.rest.controllers;


import dto.ClientDTO;
import dto.ClientDateRangeMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.ClientService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clients/")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/{client_id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("client_id") Long clientId) {
        ClientDTO clientDTO = clientService.getClientById(clientId);
        return new ResponseEntity<>(clientDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/byName/{client_name}")
    public ResponseEntity<ClientDTO> getClientByClientName(@PathVariable("client_name") String clientName) {
        ClientDTO clientDTO = clientService.getClientByClientName(clientName);
        return new ResponseEntity<>(clientDTO, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping("/all/")
    public ResponseEntity<List<ClientDTO>> allClients() {
        List<ClientDTO> clientDTOS = clientService.getClientList();
        return new ResponseEntity<>(clientDTOS, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping("/page/{page}")
    public ResponseEntity<List<ClientDTO>> getClientsByDateRange(@RequestBody @Valid ClientDateRangeMessageDTO clientDateRangeMessageDTO, @PathVariable("page") Integer page) {
        List<ClientDTO> clientDTOS = clientService.getClientListFromDateRange(clientDateRangeMessageDTO, page);
        return new ResponseEntity<>(clientDTOS, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody @Valid ClientDTO clientDTO) {
        clientService.addClient(clientDTO);
        return new ResponseEntity<>(clientDTO, new HttpHeaders(), HttpStatus.CREATED);

    }

    @DeleteMapping("/{client_id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("client_id") Long clientId) {
        clientService.removeClient(clientId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<ClientDTO> updateClient(@RequestBody @Valid ClientDTO clientDTO) {
        ClientDTO newClientDTO = clientService.updateClient(clientDTO);
        return new ResponseEntity<>(newClientDTO, new HttpHeaders(), HttpStatus.OK);
    }
}