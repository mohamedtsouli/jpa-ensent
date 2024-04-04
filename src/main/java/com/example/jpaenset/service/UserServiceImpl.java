package com.example.jpaenset.service;

import com.example.jpaenset.entities.Role;
import com.example.jpaenset.entities.User;
import com.example.jpaenset.repositories.RoleRepository;
import com.example.jpaenset.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    //injecter
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    //public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
    //this.userRepository = userRepository;   //injection via les constructeut
    //this.roleRepository = roleRepository;
    //}

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());  //pour generer une chaine de caractere qui est unique
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user=findUserByUserName(username);//chercher a partir de la base de donnees utilisateur
        Role role =findRoleByRoleName(roleName); //cgercger a partir de la base de donnes role
        if (user.getRoles()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
            //userRepository.save(user)
        }

    }

    @Override
    public User authenticate(String userName, String password) {
        User user=userRepository.findByUsername(userName);
        if(user==null) throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)) {
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}