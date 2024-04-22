package com.example.learnverse.base.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Setter
@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity <ID extends Serializable> extends AuditTrail implements Serializable{

    @SequenceGenerator(name = "id_seq",
            sequenceName = "id_seq",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_seq")
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private ID id;
    private int isDeleted;


}
