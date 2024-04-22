package com.example.learnverse.entities;

import com.example.learnverse.security.entities.JpaUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Instructor extends JpaUser {
    @Column
    private String intro;
    @ManyToMany(mappedBy = "instructors")
    private List<Course> courses;
}
