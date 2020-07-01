package by.st.deliver.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products_in_basket")
public class ProductInBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_in_basket_id")
    private Long productInBasketId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "count")
    private Integer count;

    public ProductInBasket(Order order, Product product, Integer count) {
        this.order = order;
        this.product = product;
        this.count = count;
    }
}
