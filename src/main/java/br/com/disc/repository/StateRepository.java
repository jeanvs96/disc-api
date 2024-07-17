package br.com.disc.repository;

import br.com.disc.model.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<StateEntity, Integer> {
    Optional<StateEntity> findByName(String name);
}
