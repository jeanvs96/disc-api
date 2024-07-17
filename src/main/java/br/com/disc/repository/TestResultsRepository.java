package br.com.disc.repository;

import br.com.disc.model.entity.TestResultsEntity;
import br.com.disc.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestResultsRepository extends JpaRepository<TestResultsEntity, Integer> {
    Optional<List<TestResultsEntity>> findAllByUserEntityOrderByTestDateDescTestResultIdDesc(UserEntity userEntity);

}
