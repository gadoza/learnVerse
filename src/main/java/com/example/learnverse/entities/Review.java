package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

@Entity
public class Review extends BaseEntity<Long> {
    private String description;
    private Date issueDate;
    private int nStars;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

}
