package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Client;
import dto.ClientDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);
    @Mapping(source = "privilegeLevel.value", target = "privilegeLevel")
    ClientDTO clientToClientDTO(Client client);
    @Mapping(source = "privilegeLevel", target = "privilegeLevel")
    Client clientDTOToClient(ClientDTO clientDTO);

}
