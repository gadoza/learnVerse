package com.example.learnverse.entities;

import com.example.learnverse.security.entities.JpaUser;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

import java.util.List;

@Entity
public class Instructor extends JpaUser {
    private String intro;
    @ManyToMany(mappedBy = "instructors")
    private List<Course> courses;
}
