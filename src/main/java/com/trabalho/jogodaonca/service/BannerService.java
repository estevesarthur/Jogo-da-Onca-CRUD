package com.trabalho.jogodaonca.service;

import com.trabalho.jogodaonca.model.Banner;
import com.trabalho.jogodaonca.repository.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BannerService {
    private BannerRepository bannerRepository;

    @Autowired
    public BannerService(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    public Banner cadastrar(Banner Banner) {
        return bannerRepository.save(Banner);
    }

    public Banner atualizar(Banner Banner) {
        return bannerRepository.save(Banner);
    }

    public List<Banner> buscarTodos() {
        return bannerRepository.findAll();
    }

    public Optional<Banner> buscarPorId(Long id) {
        return bannerRepository.findById(id);
    }

    public Optional<Banner> buscarPorNome(String nameBanner) {
        return bannerRepository.findByNameBannerContainingIgnoreCase(nameBanner);
    }

    public void deletarPorId(Long id) {
        bannerRepository.deleteById(id);
    }

    public void deletarPorNome(String nameBanner) {
        bannerRepository.deleteByName(nameBanner);
    }

}
