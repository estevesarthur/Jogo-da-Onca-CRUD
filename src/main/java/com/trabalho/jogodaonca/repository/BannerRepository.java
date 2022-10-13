package com.trabalho.jogodaonca.repository;

import com.trabalho.jogodaonca.model.Banner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerRepository extends JpaRepository <Banner, Long> {
    Optional<Banner> findByNameBannerContainingIgnoreCase(String nameBanner);

    void deleteByName(String nameBanner);
}
