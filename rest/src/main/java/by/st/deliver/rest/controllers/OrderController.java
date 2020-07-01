package by.st.deliver.rest.controllers;

import by.st.deliver.core.entities.Order;
import dto.ClientDTO;
import dto.ClientDateRangeMessageDTO;
import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import services.ClientService;
import services.OrderService;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/byclient/{page}/{client_id}")
    public ResponseEntity<List<OrderDTO>> getOrderByClientId(@PathVariable("client_id") Long clientId, @PathVariable("page") Integer page) {
        List<OrderDTO> orderDTO = orderService.getOrderByClientId(clientId, page);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/byrestaurant/{page}/{restaurant_id}")
    public ResponseEntity<List<OrderDTO>> getClientByRestaurant(@PathVariable("restaurant_id") Long restaurantId, @PathVariable("page") Integer page) {
        List<OrderDTO> orderDTO = orderService.getOrderByRestaurantId(restaurantId, page);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/bystatus/{page}/{status}")
    public ResponseEntity<List<OrderDTO>> getOrderByStatus(@PathVariable("status") String status, @PathVariable("page") Integer page) {
        List<OrderDTO> orderDTO = orderService.getAllByOrderStatus(status, page);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/bycourier/{page}/{courier_id}")
    public ResponseEntity<List<OrderDTO>> getClientByCourier(@PathVariable("courier_id") Long courierId, @PathVariable("page") Integer page) {
        List<OrderDTO> orderDTO = orderService.getOrderByCourierId(courierId, page);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orderDTO = orderService.getOrderList();
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{order_id}")
    public ResponseEntity<OrderDTO> deleteOrder(@PathVariable("order_id") Long orderId) {
        orderService.removeOrder(orderId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
    }


    @PostMapping
    public ResponseEntity<OrderDTO> addOrder(@RequestBody @Valid OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @PatchMapping("/{order_id}")
    public ResponseEntity<OrderDTO> payOrder(@PathVariable("order_id") Long orderId) {
        orderService.payOrder(orderId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PatchMapping("/{order_id}/{courier_id}")
    public ResponseEntity<OrderDTO> takeOrder(@PathVariable("order_id") Long orderId, @PathVariable("courier_id") Long courierId) {
        orderService.takeOrder(orderId, courierId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{page}")
    public ResponseEntity<List<OrderDTO>> getAllForCouriers(@PathVariable("page") Integer page) {
        List<OrderDTO> orderDTO = orderService.getAllForCouriers(page);
        return new ResponseEntity(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{order_id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("order_id") Long orderId) {
        OrderDTO orderDTO = orderService.getOrderById(orderId);
        return new ResponseEntity(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/get_by_client/{client_id}")
    public ResponseEntity<OrderDTO> getCurrentOrderByClientId(@PathVariable("client_id") Long clientId) {
        OrderDTO orderDTO = orderService.getCurrentOrderByClientId(clientId);
        return new ResponseEntity(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @PatchMapping("/complete/{order_id}")
    public ResponseEntity<OrderDTO> completeOrder(@PathVariable("order_id") Long orderId) {
        orderService.completeOrder(orderId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @PatchMapping("/release/{order_id}")
    public ResponseEntity<OrderDTO> releaseOrder(@PathVariable("order_id") Long orderId) {
        orderService.releaseOrder(orderId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
}

