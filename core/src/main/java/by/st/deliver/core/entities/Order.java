package by.st.deliver.core.entities;

import by.st.deliver.core.dao.OrderRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")

public class Order {


    public Order(Courier courier, Client client, Restaurant restaurant, Double totalCost, OrderStatus status, List<ProductInBasket> productInBasket) {
        this.courier = courier;
        this.client = client;
        this.restaurant = restaurant;
        this.totalCost = totalCost;
        this.status = status;
        this.productInBasket = productInBasket;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "courier_id")
    private Courier courier;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


    @Column(name = "total_cost")
    private Double totalCost;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    @OneToMany
    @JoinColumn()
    private List<ProductInBasket> productInBasket;


}
