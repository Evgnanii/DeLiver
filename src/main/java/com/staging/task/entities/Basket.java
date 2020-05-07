package com.staging.task.entities;

import javax.persistence.*;

@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_in_basket_id")
    private Long productInBasketId ;
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "count")
    private Long count;
}
