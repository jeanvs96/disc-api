package br.com.disc.repository;

import br.com.disc.model.entity.TestsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestsRepository extends JpaRepository<TestsEntity, Integer> {
}
