package com.example.learnverse.repositories;

import com.example.learnverse.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("""
        select u from User u where u.userName = :userName
        """)
    Optional<User> findUserByUserName(@Param("userName") String userName);
}
