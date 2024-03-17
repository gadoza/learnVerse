package com.example.learnverse.entities;

import com.example.learnverse.security.entities.JpaUser;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Student extends JpaUser {
    private String organization;
    @OneToMany(mappedBy = "student")
    private List<Review> reviews;
    @ManyToMany(mappedBy = "students")
    private List<Course> course;
}
