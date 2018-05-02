package org.elsys.ip.online_gun_shop.services;

import org.elsys.ip.online_gun_shop.exception.ResourceNotFoundException;
import org.elsys.ip.online_gun_shop.model.User;
import org.elsys.ip.online_gun_shop.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public User getUserById(Integer id) throws ResourceNotFoundException {
        return this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id = "
                + String.valueOf(id) + "not found"));
    }

    public User updateUser(Integer id, User user) throws ResourceNotFoundException {
        User foundUser = getUserById(id);

        return this.userRepository.save(ServiceUtil.updateFields(user, foundUser));
    }

    public void deleteUserById(Integer id) {
        this.userRepository.deleteById(id);
    }
}
