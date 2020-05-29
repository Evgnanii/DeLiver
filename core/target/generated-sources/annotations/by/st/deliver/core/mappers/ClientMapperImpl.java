package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.PrivilegeLevel;
import dto.ClientDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-28T14:16:15+0300",
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
        clientDTO.setClientId( client.getClientId() );
        clientDTO.setClientName( client.getClientName() );
        clientDTO.setClientEmail( client.getClientEmail() );
        clientDTO.setClientPhoneNumber( client.getClientPhoneNumber() );
        clientDTO.setClientAddress( client.getClientAddress() );
        clientDTO.setDateOfBirth( client.getDateOfBirth() );

        return clientDTO;
    }

    @Override
    public Client clientDTOToClient(ClientDTO clientDTO) {
        if ( clientDTO == null ) {
            return null;
        }

        Client client = new Client();

        client.setClientId( clientDTO.getClientId() );
        client.setClientName( clientDTO.getClientName() );
        client.setClientEmail( clientDTO.getClientEmail() );
        client.setClientPhoneNumber( clientDTO.getClientPhoneNumber() );
        client.setClientAddress( clientDTO.getClientAddress() );
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
