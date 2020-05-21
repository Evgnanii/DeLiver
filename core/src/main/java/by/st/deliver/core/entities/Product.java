package by.st.deliver.core.entities;


import lombok.Data;

import javax.persistence.*;

@Data
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

    @Column(name = "discount")
    private Long discount;

    public Product() {
    }

    public Product(Long productId, String productName, Double cost, Double productRating, String productWeight, Restaurant restaurant, Long discount) {
        this.productId = productId;
        this.productName = productName;
        this.cost = cost;
        this.productRating = productRating;
        this.productWeight = productWeight;
        this.restaurant = restaurant;
        this.discount = discount;
    }
}