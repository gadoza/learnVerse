package com.example.learnverse.entities;

import com.example.learnverse.security.entities.JpaUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Instructor extends JpaUser {
    @Column
    private String intro;
    @ManyToMany(mappedBy = "instructors")
    private List<Course> courses;
}
