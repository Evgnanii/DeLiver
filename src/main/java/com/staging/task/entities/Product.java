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
    @OneToMany(mappedBy="commentary_list_id")
    private Set<CommentList> commentLists;
    @Column(name = "discount")
    private Long discount;


}