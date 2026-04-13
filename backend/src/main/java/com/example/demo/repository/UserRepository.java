package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository

public interface UserRepository extends JpaRepository<User,UUID>{

    // used or log in - find the user by emailid
    // like we are using  optional because either email is present or not

    Optional<User>  findByEmail(String email);

    // user for register- check if user is already present or not

    boolean existsByEmail(String email);
}
