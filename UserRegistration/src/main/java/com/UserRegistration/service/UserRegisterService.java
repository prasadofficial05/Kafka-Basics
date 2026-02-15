package com.UserRegistration.service;

import com.UserRegistration.Entity.UserRegister;
import com.UserRegistration.Repo.UserRegisterRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterService {

    @Autowired
    private UserRegisterRepo userRepo;

    public UserRegister registerUser(UserRegister user){
  UserRegister savedUser=userRepo.save(user);
        return savedUser;
    }
}
