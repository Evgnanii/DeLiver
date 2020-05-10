package com.staging.task.entities;

import javax.persistence.*;

@Entity
@Table(name = "product_in_bastet")
public class ProductInBasket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_in_basket_id")
    private Long productInBasketId;
    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "count")
    private Integer count;

    public Long getProductInBasketId() {
        return productInBasketId;
    }

    public void setProductInBasketId(Long productInBasketId) {
        this.productInBasketId = productInBasketId;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ProductInBasket() {
    }

    public ProductInBasket(Basket basket, Product product, Integer count) {
        this.basket = basket;
        this.product = product;
        this.count = count;
    }
}
