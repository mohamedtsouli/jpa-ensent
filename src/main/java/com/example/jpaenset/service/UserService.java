package com.example.jpaenset.service;

import com.example.jpaenset.entities.Role;
import com.example.jpaenset.entities.User;

public interface UserService{
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName (String roleName);
    void addRoleToUser(String username,String roleName);
    User authenticate(String userName,String password);


}