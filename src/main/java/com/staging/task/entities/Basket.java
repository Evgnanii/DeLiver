package com.staging.task.entities;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "basket_id")
    @Getter
    @Setter
    private Long basketId ;
    @Column(name="basket_total_cost")
    @Getter
    @Setter
    private Long basketTotalCost;
}
