package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.CourierRepository;
import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.Courier;
import by.st.deliver.core.mappers.ClientMapper;
import by.st.deliver.core.mappers.CourierMapper;
import dto.ClientDTO;
import dto.CourierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.CourierService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourierServiceImpl implements CourierService {
    @Autowired
    CourierRepository courierRepository;
    @Override
    public CourierDTO addCourier(CourierDTO courierDTO) {
        Courier courier = CourierMapper.INSTANCE.courierDTOToCourier(courierDTO);
        courierRepository.save(courier);
        return courierDTO;
    }

    @Override
    public void removeCourier(Long courierId) {
        courierRepository.deleteById(courierId);
    }

    @Override
    public CourierDTO updateCourier(CourierDTO courierDTO) {
        Courier courier = CourierMapper.INSTANCE.courierDTOToCourier(courierDTO);
        if (courierRepository.findById(courier.getCourierId()) != null) {
            courierRepository.save(courier);
            return courierDTO;
        }
        return null;
    }

    @Override
    public List<CourierDTO> getCourierList() {
        List<Courier> couriers = courierRepository.findAll();
        List<CourierDTO> courierDTOS = new ArrayList<>();
        for (int i = 0; i < couriers.size(); i++) {
            courierDTOS.add(CourierMapper.INSTANCE.courierToCourierDTO(couriers.get(i)));
        }
        return courierDTOS;
    }

    @Override
    public CourierDTO getCourierById(Long courierId) {
        return CourierMapper.INSTANCE.courierToCourierDTO(courierRepository.findCourierByCourierId(courierId));
    }
}
