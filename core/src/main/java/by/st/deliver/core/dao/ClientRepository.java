package by.st.deliver.core.dao;

import by.st.deliver.core.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
