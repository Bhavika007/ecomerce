package com.Ecom.Services;

import com.Ecom.Exceptions.UserNotFoundException;
import com.Ecom.Model.User;
import com.Ecom.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    //Createuser
    public User createUser(User user) {
        return userRepo.save(user);
    }

    //getAllusers
    public List<User> getAllUser(){
        return userRepo.findAll();

    }

    public Optional<User> getUserById(Long Userid) throws UserNotFoundException {
        Optional<User> user=userRepo.findById(Userid);

        if(!user.isPresent())
            throw new UserNotFoundException("user not found");
        return user;
    }


    public void deleteUserById(Long Userid) {

        Optional<User> user=userRepo.findById(Userid);
        if(!user.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"employee not found in repo,enter correct details");
        }

        userRepo.deleteById(Userid);

    }


    public User updateUserById(Long Userid,String newName) throws UserNotFoundException {

        if(!userRepo.findById(Userid).isPresent()) {
            throw new UserNotFoundException("user not found");
        }
        User user=userRepo.getOne(Userid);
        user.setFirstName(newName);
        return userRepo.save(user);

    }

}
