package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "field_of_interest")
@Getter
@Setter
public class FieldOfInterestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FIELD_OF_INTEREST_SEQ")
    @SequenceGenerator(name = "FIELD_OF_INTEREST_SEQ", sequenceName = "seq_field_of_interest", allocationSize = 1)
    @Column(name = "field_of_interest_id")
    private Integer fieldOfInterestId;

    @Column(name = "field")
    private String field;

    @OneToOne(mappedBy = "fieldOfInterestEntity")
    @Transient
    private UserEntity userEntity;
}
