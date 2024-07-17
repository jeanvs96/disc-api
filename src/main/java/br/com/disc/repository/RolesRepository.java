package br.com.disc.repository;

import br.com.disc.model.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RolesEntity, Integer> {
    RolesEntity findByRoleName(String roleName);
}
