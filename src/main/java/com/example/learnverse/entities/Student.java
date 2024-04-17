package com.example.learnverse.entities;

import com.example.learnverse.security.entities.JpaUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Student extends JpaUser {
    @Column
    private String organization;
    @ManyToMany
    @JoinTable(
            name = "courses_taken_by_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
