package by.st.deliver.rest.controllers;



import dto.ClientDTO;
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

        if (clientService.getClientById(clientId) != null) {
            ClientDTO clientDTO = clientService.getClientById(clientId);
            return new ResponseEntity<>(clientDTO, new HttpHeaders(), HttpStatus.OK);
        } else
            throw new RuntimeException();
    }

    @GetMapping("/clients/")
    public ResponseEntity<List<ClientDTO>> allClients() {
        List<ClientDTO> clientDTOS = clientService.getClientList();
        if (clientDTOS != null) {
            return new ResponseEntity<>(clientDTOS, new HttpHeaders(), HttpStatus.OK);
        }
        throw new RuntimeException();
    }

    @PostMapping
    public ResponseEntity<ClientDTO> addClient(@RequestBody @Valid ClientDTO clientDTO) {
        if (clientService.getClientById(clientDTO.getClientId()) != null) {
            clientService.addClient(clientDTO);
            return new ResponseEntity<>(clientDTO, new HttpHeaders(), HttpStatus.OK);
        }
        throw new RuntimeException();
    }

    @DeleteMapping("/{client_id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("client_id") Long clientId) {
        if (clientService.getClientById(clientId) != null) {
            clientService.removeClient(clientId);
        }
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<ClientDTO> updateClient(@RequestBody @Valid ClientDTO clientDTO) {
        ClientDTO newClientDTO = clientService.updateClient(clientDTO);
        if (newClientDTO != null){
            return new ResponseEntity<>(newClientDTO, new HttpHeaders(), HttpStatus.OK);}
        else throw new RuntimeException();
    }
}