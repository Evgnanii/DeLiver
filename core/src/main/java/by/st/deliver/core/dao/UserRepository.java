package by.st.deliver.core.dao;

import by.st.deliver.core.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
}
