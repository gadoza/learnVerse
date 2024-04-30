package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import com.example.learnverse.security.entities.JpaUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course extends BaseEntity<Long> {
    @Column
    private String courseName;
    @Column
    private String description;
    @Column
    private BigDecimal price;
    @ManyToMany(mappedBy = "takenCourses")
    private Set<JpaUser> students;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Tag> tags;

    @ManyToMany(mappedBy = "taughtCourses")
    private Set<JpaUser> instructors;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews;

    @Lob
    @Column
    private byte[] image;

}
