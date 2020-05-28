package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.CourierRepository;
import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.Courier;
import by.st.deliver.core.mappers.ClientMapper;
import by.st.deliver.core.mappers.CommentMapper;
import by.st.deliver.core.mappers.CourierMapper;
import by.st.deliver.core.servicesImpl.exceptions.DataAlreadyExistException;
import by.st.deliver.core.servicesImpl.exceptions.MinRatingException;
import by.st.deliver.core.servicesImpl.exceptions.NoDataException;
import by.st.deliver.core.servicesImpl.exceptions.NoSuchDataExceptionQ;
import dto.CourierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import services.CourierService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourierServiceImpl implements CourierService {
    @Autowired
    CourierRepository courierRepository;

    @Override
    public Long addCourier(CourierDTO courierDTO) {
        Courier courier = CourierMapper.INSTANCE.courierDTOToCourier(courierDTO);
        if (courierRepository.findCourierByCourierId(courierDTO.getCourierId()) != null) {
            throw new DataAlreadyExistException("Courier with id " + courierDTO.getCourierId() + " already exists");
        }
        courierRepository.save(courier);
        return courierDTO.getCourierId();
    }

    @Override
    public void removeCourier(Long courierId) {
        if (courierRepository.findCourierByCourierId(courierId) == null) {
            throw new NoSuchDataExceptionQ("There is no courier with id " + courierId);
        }
        courierRepository.deleteById(courierId);
    }

    @Override
    public CourierDTO updateCourier(CourierDTO courierDTO) {
        if (courierRepository.findById(courierDTO.getCourierId()) == null) {
            throw new NoSuchDataExceptionQ("There is no courier with id " + courierDTO.getCourierId());
        }
        Courier courier = CourierMapper.INSTANCE.courierDTOToCourier(courierDTO);
        courierRepository.save(courier);
        return courierDTO;
    }

    @Override
    public List<CourierDTO> getCourierList() {
        List<Courier> couriers = courierRepository.findAll();
        if (couriers.isEmpty()) {
            throw new NoDataException("There are no couriers on server");
        }
        List<CourierDTO> courierDTOS = couriers.stream().map(r -> CourierMapper.INSTANCE.courierToCourierDTO(r)).collect(Collectors.toList());
        return courierDTOS;
    }

    @Override
    public CourierDTO getCourierById(Long courierId) {
        CourierDTO courierDTO = CourierMapper.INSTANCE.courierToCourierDTO(courierRepository.findCourierByCourierId(courierId));
        if (courierDTO == null) {
            throw new NoSuchDataExceptionQ("There is no courier with id " + courierId);
        }
        return courierDTO;
    }

    @Override
    public List<CourierDTO> getCouriersByRating(Long minRating) {
        if (minRating >= 5 || minRating <= 1) {
            throw new MinRatingException("Rating must be lower than 5 and higher than 1 ");
        }
        List<Courier> couriers = courierRepository.findAllByCourierRatingGreaterThanOrderByCourierRating(minRating);
        if (couriers.isEmpty()) {
            throw new NoDataException("There are no couriers with rating more than " + minRating);
        }
        return couriers.stream().map(courier -> CourierMapper.INSTANCE.courierToCourierDTO(courier)).collect(Collectors.toList());
    }
}
