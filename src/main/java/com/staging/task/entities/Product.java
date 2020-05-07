package com.staging.task.entities;

import javax.persistence.*;

@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_name")
    private String productName;
    @Column(name = "product_cost")
    private Double cost;
    @Column(name = "product_rating")
    private Double productRating;
    @Column(name = " product_weight")
    private String productWeight;
    @Column(name = "restaurant_id")
    private Long restaurantId;
    @Column (name = "commentary_id")
    private Long commentaryId;
    @Column(name = "discount")
    private Long discount;
    public Long getCommentaryId() {
        return commentaryId;
    }

    public void setCommentaryId(Long commentaryId) {
        this.commentaryId = commentaryId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getProductRating() {
        return productRating;
    }

    public void setProductRating(Double productRating) {
        this.productRating = productRating;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }

    public Product() {
    }

    public Product(String productName, Double cost, Double productRating, String productWeight, Long restaurantId, Long commentaryId, Long discount) {
        this.productName = productName;
        this.cost = cost;
        this.productRating = productRating;
        this.productWeight = productWeight;
        this.restaurantId = restaurantId;
        this.commentaryId = commentaryId;
        this.discount = discount;
    }


}