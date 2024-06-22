package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category extends BaseEntity<Long> {
    @Column
    private String nameEn;
    @Column
    private String nameAr;
    @Column
    private String code;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.EAGER)
    private Set<Course> courses;
}
