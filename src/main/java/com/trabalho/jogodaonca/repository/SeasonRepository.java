package com.trabalho.jogodaonca.repository;

import com.trabalho.jogodaonca.model.Season;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository <Season, Long> {
    Optional<Season> findByNameSeasonContainingIgnoreCase(String nameSeason);

    void deleteByName(String nameSeason);
}