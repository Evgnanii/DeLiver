package by.st.deliver.core.dao;


import java.util.List;
import java.util.Optional;

import by.st.deliver.core.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductById(Long id);

    List<Product> findAllByRestaurantId(Long restaurantId, Pageable pageable);

}
