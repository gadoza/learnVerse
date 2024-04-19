package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course extends BaseEntity<Long> {
    private String courseName;
    private String description;
    private BigDecimal price;
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Tag> tags;
    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "instructor_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Instructor> instructors;

    @Lob
    @Column
    private byte[] image;

}
