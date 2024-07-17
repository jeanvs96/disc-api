package br.com.disc.repository;

import br.com.disc.model.entity.EducationLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EducationLevelRepository extends JpaRepository<EducationLevelEntity, Integer> {
    Optional<EducationLevelEntity> findByEducationLevel(String educationLevel);
}
