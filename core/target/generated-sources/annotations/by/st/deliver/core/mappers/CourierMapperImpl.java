package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Courier;
import by.st.deliver.core.entities.CourierStatus;
import dto.CourierDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-21T19:54:49+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class CourierMapperImpl implements CourierMapper {

    @Override
    public CourierDTO courierToCourierDTO(Courier courier) {
        if ( courier == null ) {
            return null;
        }

        CourierDTO courierDTO = new CourierDTO();

        courierDTO.setStatus( courierStatusValue( courier ) );
        courierDTO.setId( courier.getId() );
        courierDTO.setPassword( courier.getPassword() );
        courierDTO.setRating( courier.getRating() );

        return courierDTO;
    }

    @Override
    public Courier courierDTOToCourier(CourierDTO courierDTO) {
        if ( courierDTO == null ) {
            return null;
        }

        Courier courier = new Courier();

        courier.setId( courierDTO.getId() );
        courier.setPassword( courierDTO.getPassword() );
        courier.setRating( courierDTO.getRating() );
        if ( courierDTO.getStatus() != null ) {
            courier.setStatus( Enum.valueOf( CourierStatus.class, courierDTO.getStatus() ) );
        }

        return courier;
    }

    private String courierStatusValue(Courier courier) {
        if ( courier == null ) {
            return null;
        }
        CourierStatus status = courier.getStatus();
        if ( status == null ) {
            return null;
        }
        String value = status.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }
}
