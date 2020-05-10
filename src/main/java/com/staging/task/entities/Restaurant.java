package com.staging.task.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;
    @Column(name = "restaurant_name", nullable = false, unique = true)
    private String restaurantName;
    @Enumerated(EnumType.STRING)
    @Column(name = "restaurant_kitchen_type", nullable = false, unique = true)
    private KitchenType restaurantKitchenType;
    @Column(name = "restaurant_phone_number")
    private String restaurantPhoneNumber;
    @Column(name = "restaurant_address")
    private String restaurantAddress;
    @Column(name = "rating")
    private Double rating;
    @OneToMany(mappedBy="restaurant")
    private Set<CommentList> commentLists;

    public Restaurant(String restaurantName, KitchenType restaurantKitchenType, String restaurantPhoneNumber, String restaurantAddress, Double rating, Set<CommentList> commentLists) {
        this.restaurantName = restaurantName;
        this.restaurantKitchenType = restaurantKitchenType;
        this.restaurantPhoneNumber = restaurantPhoneNumber;
        this.restaurantAddress = restaurantAddress;
        this.rating = rating;
        this.commentLists = commentLists;
    }

    public Restaurant() {
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public KitchenType getRestaurantKitchenType() {
        return restaurantKitchenType;
    }

    public void setRestaurantKitchenType(KitchenType restaurantKitchenType) {
        this.restaurantKitchenType = restaurantKitchenType;
    }

    public String getRestaurantPhoneNumber() {
        return restaurantPhoneNumber;
    }

    public void setRestaurantPhoneNumber(String restaurantPhoneNumber) {
        this.restaurantPhoneNumber = restaurantPhoneNumber;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Set<CommentList> getCommentLists() {
        return commentLists;
    }

    public void setCommentLists(Set<CommentList> commentLists) {
        this.commentLists = commentLists;
    }
}