package com.example.demo.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity(name = "users")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "seq_users", allocationSize = 1)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RolesEntity> rolesEntities;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private CityEntity cityEntity;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "education_level_id", referencedColumnName = "education_level_id")
    private EducationLevelEntity educationLevelEntity;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "field_of_interest_id", referencedColumnName = "field_of_interest_id")
    private FieldOfInterestEntity fieldOfInterestEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity")
    @JsonManagedReference
    private List<TestResultsEntity> resultEntity;

    @Transient
    private OngoingTestEntity ongoingTestEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return rolesEntities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }

    @Embeddable
    public static class UsersRoles implements Serializable {

        private static final long serialVersionUID = 1L;

        private Integer idUserRole;
        private Integer userId;
        private Integer roleId;

        public UsersRoles() {}

        public UsersRoles(Integer userId, Integer roleId) {
            super();
            this.userId = userId;
            this.roleId = roleId;
        }

        public Integer getUserId() {
            return userId;
        }

        public Integer getRoleId() {
            return roleId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public void setRoleId(Integer roleId) {
            this.roleId = roleId;
        }
    }
}