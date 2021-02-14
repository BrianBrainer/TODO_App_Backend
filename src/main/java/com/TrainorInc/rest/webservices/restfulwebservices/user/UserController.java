package com.TrainorInc.rest.webservices.restfulwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path="/register" )
    public ResponseEntity<UserEntity> registerUser(@RequestBody UserEntity userEntityToRegister){

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userEntityToRegister.setPassword(encoder.encode(userEntityToRegister.getPassword()));
        userService.save(userEntityToRegister);

        return new ResponseEntity<UserEntity>(userEntityToRegister, HttpStatus.OK);
    }

    @GetMapping(path="/register/validateUsername/{username}")
    public Boolean checkIfUsernameExists(@PathVariable String username)
    {
        UserEntity user = userService.findUserByUsername(username);

        if(null != user)
        {
            return true;
        }

        return false;
    }

    @GetMapping(path="/register/validateEmail/{email}")
    public Boolean checkIfEmailExists(@PathVariable String email)
    {
        UserEntity user = userService.findUserByEmail(email);

        if(null != user)
        {
            return true;
        }

        return false;
    }
}
