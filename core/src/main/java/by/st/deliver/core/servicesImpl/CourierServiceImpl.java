package by.st.deliver.core.servicesImpl;

import by.st.deliver.core.dao.CourierRepository;
import by.st.deliver.core.dao.OrderRepository;
import by.st.deliver.core.entities.Courier;
import by.st.deliver.core.entities.Order;
import by.st.deliver.core.entities.OrderStatus;
import by.st.deliver.core.mappers.CourierMapper;
import by.st.deliver.core.servicesImpl.exceptions.*;

import dto.CourierDTO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import services.CourierService;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourierServiceImpl implements CourierService {
    @Autowired
    CourierRepository courierRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Long addCourier(CourierDTO courierDTO) {
        Optional<Courier> courier = Optional.ofNullable(CourierMapper.INSTANCE.courierDTOToCourier(courierDTO));
        courier.orElseThrow(() -> new DataAlreadyExistException("Courier with id " + courierDTO.getId() + " already exists"));
        courierRepository.save(courier.get());
        return courierDTO.getId();
    }

    @Override
    public void removeCourier(Long courierId) {
        Optional<Courier> courier = Optional.ofNullable(courierRepository.findCourierById(courierId));
        courier.orElseThrow(() -> new NoSuchDataException("There is no courier with id " + courierId));
        courierRepository.deleteById(courierId);
    }

    @Override
    public CourierDTO updateCourier(CourierDTO courierDTO) {
        Optional<Courier> courier = Optional.ofNullable(courierRepository.findCourierById(courierDTO.getId()));
        courier.orElseThrow(() -> new NoSuchDataException("There is no courier with id " + courierDTO.getId()));
        Courier courier1 = CourierMapper.INSTANCE.courierDTOToCourier(courierDTO);
        courierRepository.save(courier1);
        return courierDTO;
    }

    @Override
    public List<CourierDTO> getCourierList() {
        Optional<List<Courier>> couriers = Optional.ofNullable(courierRepository.findAll());
        couriers.orElseThrow(() -> new NoDataException("There are no couriers on server"));
        List<CourierDTO> courierDTOS = couriers.get().stream().map(r -> CourierMapper.INSTANCE.courierToCourierDTO(r)).collect(Collectors.toList());
        return courierDTOS;
    }

    @Override
    public CourierDTO getCourierById(Long courierId) {
        Optional<CourierDTO> courierDTO = Optional.ofNullable(CourierMapper.INSTANCE.courierToCourierDTO(courierRepository.findCourierById(courierId)));
        courierDTO.orElseThrow(() -> new NoSuchDataException("There is no courier with id " + courierId));
        return courierDTO.get();
    }

    @Override
    public List<CourierDTO> getCouriersByRating(Long minRating, Integer page) {
        if (minRating >= 5 || minRating <= 1) {
            throw new MinRatingException("Rating must be lower than 5 and higher than 1 ");
        }

        Optional<List<Courier>> couriers = Optional.ofNullable(courierRepository.findAllByRatingGreaterThanOrderByRating(minRating,PageRequest.of(page, 10)));
        couriers.orElseThrow(() -> new NoDataException("There are no couriers with rating more than " + minRating));
        return couriers.get().stream().map(courier -> CourierMapper.INSTANCE.courierToCourierDTO(courier)).collect(Collectors.toList());
    }

    @Override
    public Long getOrder(Long orderId, Long courierId) {
        Optional<Courier> courier = courierRepository.findById(courierId);
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        optionalOrder.orElseThrow(() -> new NoSuchDataException("There are no order with id " + orderId));
        Order order = optionalOrder.get();
        if (order.getStatus().equals(OrderStatus.WITHOUTCOURIER)) {
            order.setCourier(courier.get());
            orderRepository.save(order);
            return orderId;

        } else throw new OrderAlreadyReleasedException("Order with id " + orderId + " alreadyReleased");
    }
}
