package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductId(Long id);
    Iterable<Product> findAllByRestaurantRestaurantId(Long restaurantId);

}
