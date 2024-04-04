package com.example.jpaenset.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="USERS")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    private  String userId;
    @Column(name="USER_NAME",unique = true,length=20)//indexe unique je peux pas avoir 2 utilisateur qui on le meme user name et ne depasse pas 20 caractere

    private  String username;
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER ) //dans role on a un attribut users
    //à chaque fois que je veux charger un users il va charger automatique les roles de l utilisateur (eager)
    private List<Role> roles=new ArrayList<>();//un user peut avoir plusieur role /new arraylist pour eviter une excepetion
}