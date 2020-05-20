package by.st.deliver.core.dao;

import by.st.deliver.core.entities.ProductInBasket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ProductInBasketRepository extends JpaRepository<ProductInBasket, Long> {
    List<ProductInBasket> findAllByClientClientId(Long id);
    ProductInBasket findByProductInBasketId(Long id);

}