package com.dhram.services;

import com.dhram.entities.User;
import com.dhram.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;


    public ResponseEntity<User> getUser(String email){
        return new ResponseEntity<>(userRepo.findByEmail(email), HttpStatus.OK);
    }

    public ResponseEntity<String> createUser(User user) {
        userRepo.save(user);
        return new ResponseEntity<>("User registered successfully",HttpStatus.OK);
    }
}
