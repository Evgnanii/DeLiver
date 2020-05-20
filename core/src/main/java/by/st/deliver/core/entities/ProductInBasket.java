package by.st.deliver.core.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products_in_basket")
public class ProductInBasket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_in_basket_id")
    private Long productInBasketId;



    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "count")
    private Integer count;
    public Long getProductInBasketId() {
        return productInBasketId;
    }

    public void setProductInBasketId(Long productInBasketId) {
        this.productInBasketId = productInBasketId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
