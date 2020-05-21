package by.st.deliver.core.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    @Column(name = "total_cost")
    private Double totalCost;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus orderStatus;

    public Order(Long orderId, Courier courier, Client client, Restaurant restaurant, Double totalCost, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.courier = courier;
        this.client = client;
        this.restaurant = restaurant;
        this.totalCost = totalCost;
        this.orderStatus = orderStatus;
    }

    public Order() {
    }
}
