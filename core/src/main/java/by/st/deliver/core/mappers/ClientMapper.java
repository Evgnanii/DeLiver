package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Client;
import dto.ClientDTO;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "privilegeLevel.value", target = "privilegeLevel")
    ClientDTO clientToClientDTO(Client client);

    Client clientDTOToClient(ClientDTO clientDTO);

    @IterableMapping(elementTargetType = ClientDTO.class)
    List<ClientDTO> clientListToClientDTOList(List<Client> clientList);

}
