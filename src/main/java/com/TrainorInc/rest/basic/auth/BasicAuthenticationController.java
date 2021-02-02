package com.TrainorInc.rest.basic.auth;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*", allowedHeaders = "*")
public class BasicAuthenticationController {
    //get Method
    //URI - /hello-world

    //Method - "Hello World"
    //other type of mapping like GetMapping, PutMapping, DeleteMapping, PostMapping which remove need for method type param
    @GetMapping(path="/basicauth")
    public AuthenticationBean checkIfAuthenticated(){
        //throw new RuntimeException("Something Went Wrong");
        return new AuthenticationBean("Authenticated");
    }
}
