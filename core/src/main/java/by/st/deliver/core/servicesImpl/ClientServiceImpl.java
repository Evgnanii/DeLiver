package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.ClientRepository;
import by.st.deliver.core.entities.Client;
import by.st.deliver.core.mappers.ClientMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataExceptionQ;
import dto.ClientDTO;
import dto.ClientDateRangeMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.ClientService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public ClientDTO getClientByClientName(String clientName) {
        ClientDTO clientDTO = ClientMapper.INSTANCE.clientToClientDTO(clientRepository.findClientByClientName(clientName));
        if (clientDTO == null) throw new NoSuchDataExceptionQ("There is no client with name " + clientName);
        return clientDTO;
    }

    @Override
    public Long addClient(ClientDTO clientDTO) {
        Client client = ClientMapper.INSTANCE.clientDTOToClient(clientDTO);
        if (clientRepository.findById(clientDTO.getClientId()) != null) {
            throw new DataAlreadyExistException("Client with id " + clientDTO.getClientId() + " already exists");
        } else
            clientRepository.save(client);
        return clientDTO.getClientId();
    }

    @Override
    public void removeClient(Long clientId) {
        if (clientRepository.findById(clientId) == null) {
            throw new NoSuchDataExceptionQ("There is no user with id " + clientId);
        } else
            clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        if (clientRepository.findById(clientDTO.getClientId()) == null) {
            throw new NoSuchDataExceptionQ("There is no user with id " + clientDTO.getClientId());
        }
        Client client = ClientMapper.INSTANCE.clientDTOToClient(clientDTO);
        clientRepository.save(client);
        return clientDTO;
    }

    @Override
    public List<ClientDTO> getClientList() {
        List<Client> clients = clientRepository.findAll();
        if (clients.isEmpty()) {
            throw new NoDataException("There are no clients on server");
        }
        List<ClientDTO> clientDTOS = clients.stream().map(s -> ClientMapper.INSTANCE.clientToClientDTO(s)).collect(Collectors.toList());
        return clientDTOS;
    }

    @Override
    public List<ClientDTO> getClientListFromDateRange(ClientDateRangeMessageDTO clientDateRangeMessageDTO) {

        List<Client> clients = clientRepository.findAllByDateOfBirthBetween(clientDateRangeMessageDTO.getDateRangeStart(), clientDateRangeMessageDTO.getDateRangeEnd());
        if (clients.isEmpty()) {
            throw new NoDataException("There are no clients with date of birth in a range between "
                    + clientDateRangeMessageDTO.getDateRangeStart()
                    + " and " + clientDateRangeMessageDTO.getDateRangeEnd());
        }
        return ClientMapper.INSTANCE.clientListToClientDTOList(clients);
    }

    @Override
    public ClientDTO getClientById(Long clientId) {
        ClientDTO clientDTO = ClientMapper.INSTANCE.clientToClientDTO(clientRepository.findClientByClientId(clientId));
        if (clientDTO == null) throw new NoSuchDataExceptionQ("There is no client with name " + clientId);
        return clientDTO;
    }
}
