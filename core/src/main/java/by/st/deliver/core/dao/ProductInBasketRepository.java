package by.st.deliver.core.dao;

import by.st.deliver.core.entities.ProductInBasket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInBasketRepository extends JpaRepository<ProductInBasket, Long> {
    List<ProductInBasket> findAllByOrderOrderId(Long id);
    ProductInBasket findByProductInBasketId(Long id);

}
