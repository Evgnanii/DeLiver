package services;

import dto.CourierDTO;

import java.util.List;

public interface CourierService {
    public Long addCourier(CourierDTO courierDTO);

    public void removeCourier(Long courierId);

    public CourierDTO updateCourier(CourierDTO courierDTO);

    public List<CourierDTO> getCourierList();

    public CourierDTO getCourierById(Long id);

    public List<CourierDTO> getCouriersByRating(Long minRating, Integer page);

    public Long getOrder(Long orderId, Long courierId);

}