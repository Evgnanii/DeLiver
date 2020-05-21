package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Client;

import by.st.deliver.core.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;


public interface ClientRepository extends JpaRepository<Client, Long> {

}
