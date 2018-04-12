package org.elsys.ip.online_gun_shop.controller;

import org.elsys.ip.online_gun_shop.model.User;
import org.elsys.ip.online_gun_shop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public User signUp(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(value = "id") Integer id) {
        return this.userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable(value = "id") Integer id, @RequestBody User requestedUser) {
        return this.userService.updateUser(id, requestedUser);
    }
}
