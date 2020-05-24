package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.Courier;
import dto.ClientDTO;
import dto.CourierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourierMapper {
    CourierMapper INSTANCE = Mappers.getMapper(CourierMapper.class);
    @Mapping(source = "courierStatus.value", target = "courierStatus")
    CourierDTO courierToCourierDTO(Courier courier);
    @Mapping(source = "courierStatus", target = "courierStatus")
    Courier courierDTOToCourier(CourierDTO courierDTO);

}

