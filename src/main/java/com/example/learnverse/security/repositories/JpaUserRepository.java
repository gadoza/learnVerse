package com.example.learnverse.security.repositories;

import com.example.learnverse.security.entities.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaUserRepository extends JpaRepository<JpaUser, Long>{
    Optional<JpaUser> findJpaUserById(Long id);

    @Query("""
            SELECT U FROM JpaUser U WHERE U.userName = :userName
""")
    Optional<JpaUser> findJpaUsersByUserName(@Param("userName") String userName);


    @Query("""
            SELECT
             U.password
             FROM JpaUser U WHERE U.userName = :userName
""")
    Optional<String> findPasswordByUserName(@Param("userName") String userName);
}
