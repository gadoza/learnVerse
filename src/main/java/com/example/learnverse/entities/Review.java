package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import com.example.learnverse.security.entities.JpaUser;
import jakarta.persistence.*;
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
    private Course course;

    //unidirectional from the many(Review) side
    @ManyToOne
    private JpaUser user;

}
