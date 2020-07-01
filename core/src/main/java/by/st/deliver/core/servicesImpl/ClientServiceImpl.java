package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.ClientRepository;
import by.st.deliver.core.dao.OrderRepository;
import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.Order;
import by.st.deliver.core.entities.OrderStatus;
import by.st.deliver.core.mappers.ClientMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataException;

import by.st.deliver.core.servicesImpl.exceptions.OrderAlreadyReleasedException;
import dto.ClientDTO;
import dto.ClientDateRangeMessageDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import services.ClientService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    OrderRepository orderRepository;

    @Override
    public ClientDTO getClientByClientName(String clientName) {
        Optional<ClientDTO> clientDTO = Optional.ofNullable(ClientMapper.INSTANCE.clientToClientDTO(clientRepository.findClientByUsername(clientName)));
        clientDTO.orElseThrow(() -> new NoSuchDataException("There are no client with name " + clientName));
        return clientDTO.get();

    }

    @Override
    public Long addClient(ClientDTO clientDTO) {
        Optional<Client> client = Optional.ofNullable(ClientMapper.INSTANCE.clientDTOToClient(clientDTO));
        client.orElseThrow(() -> new DataAlreadyExistException("Client with id " + clientDTO.getId() + " already exists"));
        clientRepository.save(client.get());
        return clientDTO.getId();
    }

    @Override
    public void removeClient(Long clientId) {
        Optional<Client> client = Optional.ofNullable(clientRepository.getOne(clientId));
        client.orElseThrow(() -> new NoSuchDataException("There is no client with id " + clientId));
        clientRepository.deleteById(clientId);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Optional<Client> client = Optional.ofNullable(ClientMapper.INSTANCE.clientDTOToClient(clientDTO));
        client.orElseThrow(() -> new NoSuchDataException("There is no client with id " + clientDTO.getId()));
        clientRepository.save(client.get());
        return clientDTO;
    }

    @Override
    public List<ClientDTO> getClientList() {
        Optional<List<Client>> clients = Optional.ofNullable(clientRepository.findAll());
        clients.orElseThrow(() -> new NoDataException("There are no clients on server"));
        List<ClientDTO> clientDTOS = clients.get().stream().map(s -> ClientMapper.INSTANCE.clientToClientDTO(s)).collect(Collectors.toList());
        return clientDTOS;
    }

    @Override
    public List<ClientDTO> getClientListFromDateRange(ClientDateRangeMessageDTO clientDateRangeMessageDTO, Integer page) {
        Optional<List<Client>> clients = Optional.ofNullable(clientRepository
                .findAllByDateOfBirthBetween(clientDateRangeMessageDTO.getDateRangeStart(), clientDateRangeMessageDTO.getDateRangeEnd(), PageRequest.of(page, 5)));
        clients.orElseThrow(() -> new NoDataException("There are no clients with date of birth in a range between "
                + clientDateRangeMessageDTO.getDateRangeStart()
                + " and " + clientDateRangeMessageDTO.getDateRangeEnd()));
        return ClientMapper.INSTANCE.clientListToClientDTOList(clients.get());
    }

    @Override
    public ClientDTO getClientById(Long clientId) {
        Optional<ClientDTO> clientDTO = Optional.ofNullable(ClientMapper.INSTANCE.clientToClientDTO(clientRepository.findClientById(clientId)));
        clientDTO.orElseThrow(() -> new NoSuchDataException("There is no client with name " + clientId));
        return clientDTO.get();
    }
}
