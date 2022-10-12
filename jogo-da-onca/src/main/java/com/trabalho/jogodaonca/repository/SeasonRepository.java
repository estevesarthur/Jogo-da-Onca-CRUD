package com.trabalho.jogodaonca.repository;

import com.trabalho.jogodaonca.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository <Season, Long> {
}
