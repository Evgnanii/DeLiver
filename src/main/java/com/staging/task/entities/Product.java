package com.staging.task.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
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
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
    @OneToMany(mappedBy="product")
    private Set<CommentList> commentLists;
    @Column(name = "discount")
    private Long discount;

    public Product(String productName, Double cost, Double productRating, String productWeight, Restaurant restaurant, Set<CommentList> commentLists, Long discount) {
        this.productName = productName;
        this.cost = cost;
        this.productRating = productRating;
        this.productWeight = productWeight;
        this.restaurant = restaurant;
        this.commentLists = commentLists;
        this.discount = discount;
    }

    public Product() {
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<CommentList> getCommentLists() {
        return commentLists;
    }

    public void setCommentLists(Set<CommentList> commentLists) {
        this.commentLists = commentLists;
    }

    public Long getDiscount() {
        return discount;
    }

    public void setDiscount(Long discount) {
        this.discount = discount;
    }
}