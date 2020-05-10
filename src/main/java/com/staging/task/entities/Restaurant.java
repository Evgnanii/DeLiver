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
    @OneToMany(mappedBy="commentary_list_od")
    private Set<CommentList> commentLists;

}