package br.com.disc.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity(name = "state")
@Getter
@Setter
public class StateEntity {

    @Id
    @GeneratedValue(generator = "STATE_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "STATE_SEQ", sequenceName = "seq_state", allocationSize = 1)
    @Column(name = "state_id")
    private Integer stateId;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "stateEntity")
    @Transient
    private Set<CityEntity> cityEntities;
}
