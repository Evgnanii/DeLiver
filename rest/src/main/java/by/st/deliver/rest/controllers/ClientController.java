package by.st.deliver.rest.controllers;


import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataExceptionQ;
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
        if (clientService.getClientById(clientId) == null) {
            throw new NoSuchDataExceptionQ("There is no Client with id " + clientId);
        } else {
            ClientDTO clientDTO = clientService.getClientById(clientId);
            return new ResponseEntity<>(clientDTO, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @GetMapping("/byName/{client_name}")
    public ResponseEntity<ClientDTO> getClientByClientName(@PathVariable("client_name") String clientName) {
        ClientDTO clientDTO = clientService.getClientByClientName(clientName);
        return new ResponseEntity<>(clientDTO, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping("/all/")
    public ResponseEntity<List<ClientDTO>> allClients() {
        List<ClientDTO> clientDTOS = clientService.getClientList();
        if (clientDTOS == null) {
            throw new NoDataException("There are no clients in database");
        }
        return new ResponseEntity<>(clientDTOS, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getClientsByDateRange(@RequestBody @Valid ClientDateRangeMessageDTO clientDateRangeMessageDTO) {
        List<ClientDTO> clientDTOS = clientService.getClientListFromDateRange(clientDateRangeMessageDTO);
        if (clientDTOS == null) {
            throw new NoDataException("There are no clients with date of birth between "
                    + clientDateRangeMessageDTO.getDateRangeStart()
                    + "  and "
                    + clientDateRangeMessageDTO.getDateRangeEnd());
        } else {
            return new ResponseEntity<>(clientDTOS, new HttpHeaders(), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody @Valid ClientDTO clientDTO) {
        if (clientService.getClientById(clientDTO.getClientId()) != null) {
            throw new DataAlreadyExistException("This client already exists");
        } else {
            clientService.addClient(clientDTO);
            return new ResponseEntity<>(clientDTO, new HttpHeaders(), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{client_id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("client_id") Long clientId) {
        clientService.removeClient(clientId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<ClientDTO> updateClient(@RequestBody @Valid ClientDTO clientDTO) {
        ClientDTO newClientDTO = clientService.updateClient(clientDTO);
        if (newClientDTO != null) {
            return new ResponseEntity<>(newClientDTO, new HttpHeaders(), HttpStatus.OK);
        } else throw new RuntimeException();
    }
}