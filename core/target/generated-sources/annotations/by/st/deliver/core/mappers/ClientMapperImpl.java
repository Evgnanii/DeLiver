package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.PrivilegeLevel;
import dto.ClientDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-21T19:54:49+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class ClientMapperImpl implements ClientMapper {

    @Override
    public ClientDTO clientToClientDTO(Client client) {
        if ( client == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setPrivilegeLevel( clientPrivilegeLevelValue( client ) );
        clientDTO.setId( client.getId() );
        clientDTO.setEmail( client.getEmail() );
        clientDTO.setPhoneNumber( client.getPhoneNumber() );
        clientDTO.setAddress( client.getAddress() );
        clientDTO.setDateOfBirth( client.getDateOfBirth() );

        return clientDTO;
    }

    @Override
    public Client clientDTOToClient(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setId( clientDTO.getId() );
        client.setEmail( clientDTO.getEmail() );
        client.setPhoneNumber( clientDTO.getPhoneNumber() );
        client.setAddress( clientDTO.getAddress() );
        client.setDateOfBirth( clientDTO.getDateOfBirth() );
        if ( clientDTO.getPrivilegeLevel() != null ) {
            client.setPrivilegeLevel( Enum.valueOf( PrivilegeLevel.class, clientDTO.getPrivilegeLevel() ) );
        }

        return client;
    }

    @Override
    public List<ClientDTO> clientListToClientDTOList(List<Client> clientList) {
        if ( clientList == null ) {
            return null;
        }

        List<ClientDTO> list = new ArrayList<ClientDTO>( clientList.size() );
        for ( Client client : clientList ) {
            list.add( clientToClientDTO( client ) );
        }

        return list;
    }

    private String clientPrivilegeLevelValue(Client client) {
        if ( client == null ) {
            return null;
        }
        PrivilegeLevel privilegeLevel = client.getPrivilegeLevel();
        if ( privilegeLevel == null ) {
            return null;
        }
        String value = privilegeLevel.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }
}
