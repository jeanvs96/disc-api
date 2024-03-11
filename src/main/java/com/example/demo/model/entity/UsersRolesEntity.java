package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "users_roles")
@Data
public class UsersRolesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_ROLES_SEQ")
    @SequenceGenerator(name = "USERS_ROLES_SEQ", sequenceName = "seq_users_roles", allocationSize = 1)
    @Column(name = "id_user_role")
    private Integer idUserRole;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;
}
