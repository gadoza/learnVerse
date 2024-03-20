package com.example.learnverse.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter
@Getter
public class Review {
    private String description;
    private Date issueDate;
    private int nStars;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;

}
