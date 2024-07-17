package br.com.disc.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "education_level")
@Getter
@Setter
public class EducationLevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EDUCATION_LEVEL_SEQ")
    @SequenceGenerator(name = "EDUCATION_LEVEL_SEQ", sequenceName = "seq_education_level", allocationSize = 1)
    @Column(name = "education_level_id")
    private Integer educationLevelId;

    @Column(name = "education_level")
    private String educationLevel;

    @OneToOne(mappedBy = "educationLevelEntity")
    @Transient
    private UserEntity userEntity;
}
