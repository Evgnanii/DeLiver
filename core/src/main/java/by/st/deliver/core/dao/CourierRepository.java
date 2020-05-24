package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Client;
import by.st.deliver.core.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository  extends JpaRepository<Courier, Long> {
    Courier findCourierByCourierId(Long id);
}
