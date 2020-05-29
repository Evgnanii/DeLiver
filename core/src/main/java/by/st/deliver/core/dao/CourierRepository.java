package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourierRepository  extends JpaRepository<Courier, Long> {
    Courier findCourierByCourierId(Long id);
    List<Courier> findAllByCourierRatingGreaterThanOrderByCourierRating(Long minRating);
}
