package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Client;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



import java.sql.Date;
import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientById(Long id);

    Client findClientByUsername(String clientName);

    List<Client> findAllByDateOfBirthBetween(Date startDate, Date endDate, Pageable pageable);

}
