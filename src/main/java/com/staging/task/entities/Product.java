package com.staging.task.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @Getter
    @Setter
    private Long productId;
    @Column(name = "product_name")
    @Getter
    @Setter
    private String productName;
    @Column(name = "product_cost")
    @Getter
    @Setter
    private Double cost;
    @Column(name = "product_rating")
    @Getter
    @Setter
    private Double productRating;
    @Column(name = " product_weight")
    @Getter
    @Setter
    private String productWeight;
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    @Getter
    @Setter
    private Restaurant restaurant;
    @OneToMany(mappedBy = "product")
    @Getter
    @Setter
    private Set<CommentList> commentLists;
    @Column(name = "discount")
    @Getter
    @Setter
    private Long discount;


    public Product() {
    }


}