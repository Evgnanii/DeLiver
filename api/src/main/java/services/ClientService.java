package services;


import dto.ClientDTO;
import dto.ClientDateRangeMessageDTO;

import java.util.List;

public interface ClientService {

    public ClientDTO getClientByClientName(String clientName);

    public Long addClient(ClientDTO clientDTO);

    public void removeClient(Long id);

    public ClientDTO updateClient(ClientDTO clientDTO);

    public List<ClientDTO> getClientList();

    public List<ClientDTO> getClientListFromDateRange(ClientDateRangeMessageDTO clientDateRangeMessageDTO);

    public ClientDTO getClientById(Long clientId);
}
