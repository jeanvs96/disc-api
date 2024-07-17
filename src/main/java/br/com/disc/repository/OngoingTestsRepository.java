package br.com.disc.repository;

import br.com.disc.model.entity.OngoingTestEntity;
import br.com.disc.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OngoingTestsRepository extends JpaRepository<OngoingTestEntity, Integer> {
    Optional<OngoingTestEntity> findByUserEntity(UserEntity userEntity);
}
