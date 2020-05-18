package by.st.deliver.core.services;

import by.st.deliver.core.dao.UserRepository;
import by.st.deliver.core.entities.User;
import org.springframework.beans.factory.annotation.Autowired;


public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUser(User user, Long userId) {
        user.setId(userId);
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findByUserId(id);
    }

    @Override
    public Iterable<User> listUsers() {
        return userRepository.findAll();
    }
}
