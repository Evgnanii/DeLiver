package by.st.deliver.rest.controllers;

import dto.CourierDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import services.CourierService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/couriers/")
public class CourierController {
    @Autowired
    CourierService courierService;

    @GetMapping("/{courier_id}")
    public ResponseEntity<CourierDTO> getCourierById(@PathVariable("courier_id") Long courierId) {

        CourierDTO courierDTO = courierService.getCourierById(courierId);
        return new ResponseEntity<>(courierDTO, new HttpHeaders(), HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<CourierDTO>> getCouriers() {
        List<CourierDTO> courierDTOS = courierService.getCourierList();
        return new ResponseEntity<>(courierDTOS, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/rating/{page}/{min_rating}")
    public ResponseEntity<List<CourierDTO>> addCouriers(@PathVariable("min_rating") Long minRating, @PathVariable("page") Integer page) {
        List<CourierDTO> courierDTOS = courierService.getCouriersByRating(minRating, page);
        return new ResponseEntity<>(courierDTOS, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourierDTO> addCourier(@RequestBody @Valid CourierDTO courierDTO) {
        courierService.addCourier(courierDTO);
        return new ResponseEntity<>(courierDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{courier_id}")
    public ResponseEntity<CourierDTO> deleteCourier(@PathVariable("courier_id") Long courierId) {
        courierService.removeCourier(courierId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);

    }

    @PutMapping
    public ResponseEntity<CourierDTO> updateCourier(@RequestBody @Valid CourierDTO courierDTO) {
        CourierDTO newCourierDTO = courierService.updateCourier(courierDTO);
        return new ResponseEntity<>(newCourierDTO, new HttpHeaders(), HttpStatus.OK);
    }
}