package com.example.learnverse.security.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "users")
@Entity
@Getter
@Setter
@Inheritance(strategy=InheritanceType.JOINED)
public class JpaUser extends BaseEntity<Long> {

    @Column
    private String userName;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String firstName;

    @Column
    private String familyName;

}
