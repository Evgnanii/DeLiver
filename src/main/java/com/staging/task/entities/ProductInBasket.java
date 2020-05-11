package com.staging.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_in_bastet")
public class ProductInBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_in_basket_id")
    @Getter
    @Setter
    private Long productInBasketId;
    @ManyToOne
    @JoinColumn(name = "basket_id")
    @Getter
    @Setter
    private Basket basket;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "count")
    @Getter
    @Setter
    private Integer count;


    public ProductInBasket(Basket basket, Product product, Integer count) {
        this.basket = basket;
        this.product = product;
        this.count = count;
    }
}
