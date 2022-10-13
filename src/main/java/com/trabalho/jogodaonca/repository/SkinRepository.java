package com.trabalho.jogodaonca.repository;

import com.trabalho.jogodaonca.model.Skin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkinRepository extends JpaRepository <Skin, Long> {
    Optional<Skin> findByNameSkinContainingIgnoreCase(String nome);

    void deleteByName(String nameSkin);
}
