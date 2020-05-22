package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.ClientRepository;

import by.st.deliver.core.entities.Client;
import by.st.deliver.core.mappers.ClientMapper;
import dto.ClientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ClientService;

import java.util.ArrayList;
import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        Client client = ClientMapper.INSTANCE.clientDTOToClient(clientDTO);
        clientRepository.save(client);
        return clientDTO;
    }

    @Override
    public void removeClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = ClientMapper.INSTANCE.clientDTOToClient(clientDTO);
        if (clientRepository.findById(client.getClientId()) != null) {
            clientRepository.save(client);
            return clientDTO;
        }
        return null;
    }

    @Override
    public List<ClientDTO> getClientList() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDTO> clientDTOS = new ArrayList<>();
        for (int i = 0; i < clients.size(); i++) {
            clientDTOS.add(ClientMapper.INSTANCE.clientToClientDTO(clients.get(i)));
        }
        return clientDTOS;
    }

    @Override
    public ClientDTO getClientById(Long clientId) {
        return ClientMapper.INSTANCE.clientToClientDTO(clientRepository.findClientByClientId(clientId));
    }
}
