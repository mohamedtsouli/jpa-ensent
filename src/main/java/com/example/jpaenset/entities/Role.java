package com.example.jpaenset.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;

//creation d une asociation many to many
@Entity
@Data  @NoArgsConstructor @AllArgsConstructor

public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String desc;
    @Column(length =20,unique = true)
    private String roleName;
    //Mapper une relation manytomany
    @ManyToMany(fetch = FetchType.EAGER) //relation biderectionnelle je dois utiliser mapped by
    //@JoinTable(name="Users_Roles")//la table de jointure qui va etre creer
    @ToString.Exclude //on a exclu  les users
    private List<User> users=new ArrayList<>();
}