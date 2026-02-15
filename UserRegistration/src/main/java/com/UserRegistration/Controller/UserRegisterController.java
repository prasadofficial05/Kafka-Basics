package com.UserRegistration.Controller;

import com.UserRegistration.Entity.UserRegister;
import com.UserRegistration.service.KafkaService;
import com.UserRegistration.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserRegisterController {
    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/register-User")
    public ResponseEntity<UserRegister> registerUser(@RequestBody UserRegister user){
        userRegisterService.registerUser(user);
        kafkaService.sendUserRegisteredEvent(user.getMailId());
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
