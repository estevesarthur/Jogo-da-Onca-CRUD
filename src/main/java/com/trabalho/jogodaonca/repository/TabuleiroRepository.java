package com.trabalho.jogodaonca.repository;

import com.trabalho.jogodaonca.model.Tabuleiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TabuleiroRepository extends JpaRepository <Tabuleiro, Long> {
    Optional<Tabuleiro> findByNameTabuleiroContainingIgnoreCase(String nome);

    void deleteByName(String nameTabuleiro);
}
