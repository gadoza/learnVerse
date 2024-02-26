package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "authorities", schema = "administration")
@Getter
@Setter
public class Authority extends BaseEntity<Long> {
    @Column
    private String name;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;
}
