package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users", schema = "administration")
@Getter
@Setter
public class User extends BaseEntity<Long>{

    @Column
    private String userName;

    @Column
    private String password;

}
