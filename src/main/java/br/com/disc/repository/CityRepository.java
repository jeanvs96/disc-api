package br.com.disc.repository;

import br.com.disc.model.entity.CityEntity;
import br.com.disc.model.entity.StateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Integer> {
    Optional<List<CityEntity>> findAllByStateEntity(StateEntity stateEntity);

    Optional<CityEntity> findByName(String name);
}
