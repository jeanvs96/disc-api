package br.com.disc.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "city")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityEntity {

    @Id
    @GeneratedValue(generator = "CITY_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CITY_SEQ", sequenceName = "seq_city", allocationSize = 1)
    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="state_id", nullable=false)
    private StateEntity stateEntity;

    @OneToOne(mappedBy = "cityEntity")
    @Transient
    private UserEntity userEntity;
}
