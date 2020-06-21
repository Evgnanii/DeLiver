package by.st.deliver.rest.controllers;

import by.st.deliver.core.entities.Order;
import dto.ClientDTO;
import dto.ClientDateRangeMessageDTO;
import dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<OrderDTO>> getOrderByClientId(@PathVariable("client_id") Long clientId,@PathVariable("page") Integer page) {
        List<OrderDTO> orderDTO = orderService.getOrderByClientId(clientId,page);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/byrestaurant/{page}/{restaurant_id}")
    public ResponseEntity<List<OrderDTO>> getClientByRestaurant(@PathVariable("restaurant_id") Long restaurantId,@PathVariable("page") Integer page) {
        List<OrderDTO> orderDTO = orderService.getOrderByRestaurantId(restaurantId,page);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/bystatus/{page}/{status}")
    public ResponseEntity<List<OrderDTO>> getOrderByStatus(@PathVariable("status") String status,@PathVariable("page") Integer page) {
        List<OrderDTO> orderDTO = orderService.getAllByOrderStatus(status,page);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/bycourier/{page}/{courier_id}")
    public ResponseEntity<List<OrderDTO>> getClientByCourier(@PathVariable("courier_id") Long courierId,@PathVariable("page") Integer page) {
        List<OrderDTO> orderDTO = orderService.getOrderByCourierId(courierId,page);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        List<OrderDTO> orderDTO = orderService.getOrderList();
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{order_id}")
    public ResponseEntity<ClientDTO> deleteClient(@PathVariable("order_id") Long orderId) {
        orderService.removeOrder(orderId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<OrderDTO> updateClient(@RequestBody @Valid OrderDTO orderDTO) {
        orderService.addOrder(orderDTO);
        return new ResponseEntity<>(orderDTO, new HttpHeaders(), HttpStatus.OK);
    }
}

