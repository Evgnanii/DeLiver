package services;

import dto.ClientDTO;
import dto.CourierDTO;

import java.util.List;

public interface CourierService {
    public CourierDTO addCourier(CourierDTO courierDTO);

    public void removeCourier(Long courierId);

    public CourierDTO updateCourier(CourierDTO courierDTO);

    public List<CourierDTO> getCourierList();

    public CourierDTO getCourierById(Long id);
}