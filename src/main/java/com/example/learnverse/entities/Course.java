package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
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
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;
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

    //to be efficient to get the reviews of a specific course
    //unidirectional from the course side
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id")
    private List<Review> reviews;

    @Lob
    @Column
    private byte[] image;

}
