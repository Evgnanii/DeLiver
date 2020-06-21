package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Courier;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourierRepository  extends JpaRepository<Courier, Long> {
    Courier findCourierById(Long id);
    List<Courier> findAllByRatingGreaterThanOrderByRating(Long minRating, Pageable pageable);
}
