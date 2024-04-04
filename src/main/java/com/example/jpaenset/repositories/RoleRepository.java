package com.example.jpaenset.repositories;

import com.example.jpaenset.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //c est un component de la couche dao

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}