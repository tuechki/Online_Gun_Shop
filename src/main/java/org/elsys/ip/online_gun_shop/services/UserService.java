package org.elsys.ip.online_gun_shop.services;

import org.elsys.ip.online_gun_shop.exception.ResourceNotFoundException;
import org.elsys.ip.online_gun_shop.model.Favourites;
import org.elsys.ip.online_gun_shop.model.Reviews;
import org.elsys.ip.online_gun_shop.model.User;
import org.elsys.ip.online_gun_shop.repository.FavouritesRepository;
import org.elsys.ip.online_gun_shop.repository.ReviewRepository;
import org.elsys.ip.online_gun_shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    private final FavouritesRepository favouritesRepository;

    @Autowired
    public UserService(UserRepository userRepository, ReviewRepository reviewRepository, FavouritesRepository favouritesRepository) {
        this.userRepository = userRepository;
        this.reviewRepository = reviewRepository;
        this.favouritesRepository = favouritesRepository;
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

    public List<Favourites> getUserFavourites(Integer userId) {
        return favouritesRepository.findByUserId(userId);
    }

    public List<Reviews> getUserReviews(Integer userId) {
        return reviewRepository.findByUserId(userId);
    }

    public List<Favourites> deleteUserFavourites(Integer userId) {
        return favouritesRepository.deleteByUserId(userId);
    }

    public List<Reviews> deleteUserReviews(Integer userId) {
        return reviewRepository.deleteByUserId(userId);
    }
}
