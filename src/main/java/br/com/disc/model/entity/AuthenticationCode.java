package br.com.disc.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "authentication_code")
public class AuthenticationCode {

    @Id
    @GeneratedValue(generator = "AUTHENTICATION_CODE_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "AUTHENTICATION_CODE_SEQ", sequenceName = "seq_authentication_code", allocationSize = 1)
    @Column(name = "authentication_code_id")
    private Integer authenticationCodeId;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;

    @Column(name = "code")
    private String code;

    @Column(name = "date_time")
    private LocalDateTime timestamp;

}
