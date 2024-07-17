package br.com.disc.repository;

import br.com.disc.model.entity.FieldOfInterestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FieldOfInterestRepository extends JpaRepository<FieldOfInterestEntity, Integer> {
    Optional<FieldOfInterestEntity> findByField(String field);
}
