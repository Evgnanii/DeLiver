package com.staging.task.entities;

import lombok.Getter;
import lombok.Setter;

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
    @Getter
    @Setter
    private Long restaurantId;
    @Column(name = "restaurant_name", nullable = false, unique = true)
    @Getter
    @Setter
    private String restaurantName;
    @Enumerated(EnumType.STRING)
    @Column(name = "restaurant_kitchen_type", nullable = false, unique = true)
    @Getter
    @Setter
    private KitchenType restaurantKitchenType;
    @Column(name = "restaurant_phone_number")
    @Getter
    @Setter
    private String restaurantPhoneNumber;
    @Column(name = "restaurant_address")
    @Getter
    @Setter
    private String restaurantAddress;
    @Column(name = "rating")
    @Getter
    @Setter
    private Double rating;
    @OneToMany(mappedBy = "restaurant")
    @Getter
    @Setter
    private Set<CommentList> commentLists;


    public Restaurant() {
    }
}