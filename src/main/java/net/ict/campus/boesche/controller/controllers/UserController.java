package net.ict.campus.boesche.controller.controllers;

import net.ict.campus.boesche.controller.services.UserService;
import net.ict.campus.boesche.model.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userRepository) {
        this.userService = userRepository;
    }
    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(path = "{id}")
    public User findById(@RequestBody Integer id) {
        try {
            return userService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping(path = "")
    public Iterable<User> findAll() {
        try {
            return userService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users not found");
        }

    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "sign-up", consumes = "application/json")
    public void signUP(@RequestBody User user) {
        try {
            userService.signUp(user);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Could not sign up user");
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(consumes = "application/json")
    public void updateUser(@Valid @RequestBody User user) {
        try {
            userService.updateUser(user);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Geht nicht pech");
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void deleteByID(@RequestBody Integer id) {
        try {
            userService.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }

    }
    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "username/{username}")
    public User findByName(@PathVariable String username) {
        try {
            return userService.findByName(username);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer nicht gefunden", e);
        }
    }
}



