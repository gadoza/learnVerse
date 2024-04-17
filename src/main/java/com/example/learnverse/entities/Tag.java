package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Tag extends BaseEntity<Long> {
    @Column
    private String name;
    @ManyToMany(mappedBy = "tags")
    private List<Course> courses;
}
