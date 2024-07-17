package br.com.disc.repository;

import br.com.disc.model.entity.AuthenticationCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticationCodeRepository extends JpaRepository<AuthenticationCode, Integer> {
    Optional<AuthenticationCode> findByCode(String code);
}
