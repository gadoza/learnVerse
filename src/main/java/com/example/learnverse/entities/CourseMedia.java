package com.example.learnverse.entities;

import com.example.learnverse.base.model.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "course_media")
@Where(clause = "is_deleted = 0")
@Getter
@Setter
public class CourseMedia extends BaseEntity<Long> {
    @JoinColumn(name = "course_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
    @Column(name = "title")
    private String title;

    @Column(name = "filename")
    private String filename;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "data_size")
    private long dataSize;

    @Lob
    private byte[] content;
}
