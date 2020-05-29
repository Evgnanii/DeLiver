package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Courier;
import by.st.deliver.core.entities.CourierStatus;
import dto.CourierDTO;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-05-28T14:16:15+0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.6 (JetBrains s.r.o)"
)
public class CourierMapperImpl implements CourierMapper {

    @Override
    public CourierDTO courierToCourierDTO(Courier courier) {
        if ( courier == null ) {
            return null;
        }

        CourierDTO courierDTO = new CourierDTO();

        courierDTO.setCourierStatus( courierCourierStatusValue( courier ) );
        courierDTO.setCourierId( courier.getCourierId() );
        courierDTO.setCourierFirstName( courier.getCourierFirstName() );
        courierDTO.setCourierSecondName( courier.getCourierSecondName() );
        courierDTO.setCourierRating( courier.getCourierRating() );

        return courierDTO;
    }

    @Override
    public Courier courierDTOToCourier(CourierDTO courierDTO) {
        if ( courierDTO == null ) {
            return null;
        }

        Courier courier = new Courier();

        courier.setCourierId( courierDTO.getCourierId() );
        courier.setCourierFirstName( courierDTO.getCourierFirstName() );
        courier.setCourierSecondName( courierDTO.getCourierSecondName() );
        courier.setCourierRating( courierDTO.getCourierRating() );
        if ( courierDTO.getCourierStatus() != null ) {
            courier.setCourierStatus( Enum.valueOf( CourierStatus.class, courierDTO.getCourierStatus() ) );
        }

        return courier;
    }

    private String courierCourierStatusValue(Courier courier) {
        if ( courier == null ) {
            return null;
        }
        CourierStatus courierStatus = courier.getCourierStatus();
        if ( courierStatus == null ) {
            return null;
        }
        String value = courierStatus.getValue();
        if ( value == null ) {
            return null;
        }
        return value;
    }
}
