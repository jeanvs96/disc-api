package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "main_factor_description")
@Getter
@Setter
public class MainFactorEntity {
    @Id
    @Column(name = "main_factor_description_id", nullable = false)
    @GeneratedValue(generator = "MAIN_FACTOR_DESCRIPTION_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "MAIN_FACTOR_DESCRIPTION_SEQ", sequenceName = "seq_main_factor_description", allocationSize = 1)
    private Long id;

    @Column(name = "factor")
    private String factor;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "positive_points")
    private String positivePoints;

    @Column(name = "improvement_points")
    private String improvementPoints;

    @Column(name = "keywords")
    private String keywords;
}
