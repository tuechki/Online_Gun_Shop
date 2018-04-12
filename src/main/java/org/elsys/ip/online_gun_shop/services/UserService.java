package org.elsys.ip.online_gun_shop.services;

import org.elsys.ip.online_gun_shop.exception.ResourceNotFoundException;
import org.elsys.ip.online_gun_shop.model.User;
import org.elsys.ip.online_gun_shop.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.userRepository.save(user);
    }

    public User getUserById(Integer id) throws ResourceNotFoundException {
        return this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id = "
                + String.valueOf(id) + "not found"));
    }

    public User updateUser(Integer id, User user) throws ResourceNotFoundException {
        User requestedUser = this.userRepository.findById(id)
                                 .orElseThrow(() -> new ResourceNotFoundException("User with id = "
                                         + String.valueOf(id) + "not found"));

        return this.userRepository.save(generateUpdatedUser(requestedUser));
    }

    public void deleteUserById(Integer id) {
        this.userRepository.deleteById(id);
    }

    private User generateUpdatedUser(User requestedUser) {
        return new User(requestedUser.getFirstName(), requestedUser.getLastName(),
                        requestedUser.getUsername(), requestedUser.getPassword());
    }
}
