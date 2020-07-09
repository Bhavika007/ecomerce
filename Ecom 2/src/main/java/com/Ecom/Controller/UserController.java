package com.Ecom.Controller;

import com.Ecom.Exceptions.UserNotFoundException;
import com.Ecom.Model.User;
import com.Ecom.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    //get All Employee method
    @GetMapping("/user")
    public List<User> getAllUser() {
        return userService.getAllUser();

    }

    @GetMapping("/user/{Userid}")
    public Optional<User> getEmployeeById(@PathVariable("Userid") Long Userid) {
        try {
            return userService.getUserById(Userid);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());

        }
    }

    @PostMapping("/user")
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);

    }

    @DeleteMapping("/user/{Userid}")
    public void deleteUserById(@PathVariable("Userid") Long Userid) throws UserNotFoundException {
        userService.deleteUserById(Userid);
    }


    @PutMapping("/user/{Userid}")
    public User updateUserById(@PathVariable("Userid") Long Userid,@RequestBody String newName) {
        try {
            return userService.updateUserById(Userid, newName);
        } catch (UserNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

}