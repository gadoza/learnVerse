package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users", schema = "administration")
@Getter
@Setter
public class User extends BaseEntity<Long>{

    @Column
    private String userName;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "authority_id"),
    schema = "administration")
    private Set<Authority> authorities;

}
