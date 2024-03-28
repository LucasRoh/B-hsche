package net.ict.campus.boesche.controller.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import net.ict.campus.boesche.controller.services.UserService;
import net.ict.campus.boesche.model.models.Froesche;
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
    @Operation(summary = "Get in User")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(
                    mediaType="application/json",
                    schema = @Schema(implementation= User.class)
            )),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest") })
    @GetMapping(path = "{id}")
    public User findById(@PathVariable Integer id) {
        try {
            return userService.findById(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
    }

    @ResponseStatus(HttpStatus.FOUND)
    @Operation(summary = "Get in User")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(
                    mediaType="application/json",
                    schema = @Schema(implementation= User.class)
            )),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest") })
    @GetMapping(path = "")
    public Iterable<User> findAll() {
        try {
            return userService.findAll();
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Users not found");
        }

    }


    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Post User by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")
    })
    @PostMapping(path = "/sign-up", consumes = "application/json")
    public void signUP(@RequestBody User user) {
        try {
            userService.signUp(user);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Put User by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")
    })
    @PutMapping(consumes = "application/json")
    public void updateUser(@Valid @RequestBody User user) {
        try {
            userService.updateUser(user);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Geht nicht pech");
        }
    }

    @DeleteMapping(path = "{id}")
    @Operation(summary = "Delete User by ID")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok"),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest")
    })
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void deleteByID(@PathVariable Integer id) {
        try {
            userService.deleteById(id);
        } catch (RuntimeException e) {
            throw new RuntimeException();
        }

    }
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get in User")
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Ok", content = @Content(
                    mediaType="application/json",
                    schema = @Schema(implementation= User.class)
            )),
            @ApiResponse(responseCode = "404", description = "NotFound"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "400", description = "BadRequest") })
    @GetMapping(path = "username/{username}")
    public User findByName(@PathVariable String username) {
        try {
            return userService.findByName(username);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Benutzer nicht gefunden", e);
        }
    }
}



