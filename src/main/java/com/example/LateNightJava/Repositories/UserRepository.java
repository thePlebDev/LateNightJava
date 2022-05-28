package com.example.LateNightJava.Repositories;

import com.example.LateNightJava.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT * FROM users WHERE users.username = ?1",nativeQuery = true)
    Optional<User> findByUsername(String username);
}
