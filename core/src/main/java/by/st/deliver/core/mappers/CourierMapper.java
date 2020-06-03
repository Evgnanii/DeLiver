package by.st.deliver.core.mappers;

import by.st.deliver.core.entities.Courier;
import dto.CourierDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourierMapper {
    CourierMapper INSTANCE = Mappers.getMapper(CourierMapper.class);
    @Mapping(source = "status.value", target = "status")
    CourierDTO courierToCourierDTO(Courier courier);
    Courier courierDTOToCourier(CourierDTO courierDTO);

}

