package org.elsys.ip.online_gun_shop.controller;

import org.elsys.ip.online_gun_shop.model.Favourites;
import org.elsys.ip.online_gun_shop.model.Reviews;
import org.elsys.ip.online_gun_shop.model.User;
import org.elsys.ip.online_gun_shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User createdUser = userService.createUser(user);

        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        User user = userService.getUserById(id);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUserById(@PathVariable Integer id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);

        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/favourites", method = RequestMethod.GET)
    public ResponseEntity<List<Favourites>> getUserFavourites(@PathVariable Integer userId) {
        List<Favourites> userFavourites = userService.getUserFavourites(userId);

        return new ResponseEntity<List<Favourites>>(userFavourites, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/reviews", method = RequestMethod.GET)
    public ResponseEntity<List<Reviews>> getUserReviews(@PathVariable Integer userId) {
        List<Reviews> userReviews = userService.getUserReviews(userId);

        return new ResponseEntity<List<Reviews>>(userReviews, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/favourites", method = RequestMethod.DELETE)
    public ResponseEntity<List<Favourites>> deleteUserFavourites(@PathVariable Integer userId) {
        List<Favourites> deletedFavourites = userService.deleteUserFavourites(userId);

        return new ResponseEntity<List<Favourites>>(deletedFavourites, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/reviews", method = RequestMethod.DELETE)
    public ResponseEntity<List<Reviews>> deleteUserReviews(@PathVariable Integer userId) {
        List<Reviews> deletedReviews = userService.deleteUserReviews(userId);

        return new ResponseEntity<List<Reviews>>(deletedReviews, HttpStatus.OK);
    }
}
