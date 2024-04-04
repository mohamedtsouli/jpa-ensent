package com.example.jpaenset;


import com.example.jpaenset.entities.User;
import com.example.jpaenset.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/username")
    public User user(String username){
        User user=userService.findUserByUserName(username);
        return user;
    }

}