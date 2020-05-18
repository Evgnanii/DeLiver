package services;

import by.st.deliver.core.entities.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public User addUser(User user);

    public void updateUser(User user, Long userId);

    public void removeUser(Long id);

    public User getUserById(Long id);

    public Iterable<User> listUsers();


}
