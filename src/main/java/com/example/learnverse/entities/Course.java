package com.example.learnverse.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

public class Course {
    private String courseName;
    private String description;
    private BigDecimal price;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Student> students;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Tag> tag;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Instructor> instructors;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews;
}
