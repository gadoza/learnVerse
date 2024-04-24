package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class Review extends BaseEntity<Long> {
    @Column
    private String content;
    @Column
    private Date issueDate;
    @Column
    private Long n_stars;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    //unidirectional from the many(Review) side
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
