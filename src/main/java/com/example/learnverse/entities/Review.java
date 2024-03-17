package com.example.learnverse.entities;

import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Review {
    private String description;
    private Date issueDate;
    private int nStars;
    @ManyToOne
    private Course course;
    @ManyToOne
    private Student student;

}
