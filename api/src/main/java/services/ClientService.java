package services;


import dto.ClientDTO;
import java.util.*;

public interface ClientService {
    public ClientDTO addClient(ClientDTO clientDTO);
    public void removeClient(Long id);
    public ClientDTO updateClient(ClientDTO clientDTO);
    public List<ClientDTO> getClientList();
    public ClientDTO getClientById(Long clientId);
}
