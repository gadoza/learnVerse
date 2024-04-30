package com.example.learnverse.security.entities;

import com.example.learnverse.base.model.BaseEntity;
import com.example.learnverse.entities.Course;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Table(name = "users")
@Entity
@Getter
@Setter
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

    @ManyToMany
    @JoinTable(
            name = "courses_taken_by_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> takenCourses;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> taughtCourses;

}
