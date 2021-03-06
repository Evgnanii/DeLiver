package by.st.deliver.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "restaurant_rating")
    private Double rating;


}