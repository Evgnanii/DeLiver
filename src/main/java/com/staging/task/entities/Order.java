package com.staging.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    @Getter
    @Setter
    private Long orderId;
    @ManyToOne
    @JoinColumn(name = "courier_id")
    @Getter
    @Setter
    private Courier courier;
    @ManyToOne
    @JoinColumn(name = "client_id")
    @Getter
    @Setter
    private Client client;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @Getter
    @Setter
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name = "basket_id")
    @Getter
    @Setter
    private Basket basket_id;
    @Column(name = "total_cost")
    @Getter
    @Setter
    private Double totalCost;
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    @Getter
    @Setter
    private OrderStatus orderStatus;

    public Order() {
    }
}
