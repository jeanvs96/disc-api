package br.com.disc.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import java.util.Set;

@Entity(name = "roles")
@Data
public class RolesEntity implements GrantedAuthority {

    @Id
    @GeneratedValue(generator = "ROLES_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "ROLES_SEQ", sequenceName = "seq_roles", allocationSize = 1)
    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "role_name")
    private String roleName;

    @Override
    public String getAuthority() {
        return roleName;
    }
}
