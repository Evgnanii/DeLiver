package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;


public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findClientByClientId(Long id);
    Client findClientByClientName(String clientName);
    List<Client> findAllByDateOfBirthBetween(Date startDate, Date endDate);

}
