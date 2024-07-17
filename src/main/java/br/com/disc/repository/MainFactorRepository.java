package br.com.disc.repository;

import br.com.disc.model.entity.MainFactorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MainFactorRepository extends JpaRepository<MainFactorEntity, Long> {
    Optional<MainFactorEntity> findByFactor(String factor);
}
