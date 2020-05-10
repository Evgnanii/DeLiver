package com.staging.task.entities;

import javax.persistence.*;

@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    private Long basketId ;
    @Column(name="basket_total_cost")
    private Long basketTotalCost;
}
