package com.trabalho.jogodaonca.service;

import com.trabalho.jogodaonca.model.Season;
import com.trabalho.jogodaonca.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {
    private SeasonRepository seasonRepository;

    @Autowired
    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public Season cadastrar(Season season) {
        return seasonRepository.save(season);
    }

    public Season atualizar(Season season) {
        return seasonRepository.save(season);
    }

    public List<Season> buscarTodos() {
        return seasonRepository.findAll();
    }

    public Optional<Season> buscarPorId(Long id) {
        return seasonRepository.findById(id);
    }

    public Optional<Season> buscarPorNome(String nameSeason) {
        return seasonRepository.findByNameSeasonContainingIgnoreCase(nameSeason);
    }

    public void deletarPorId(Long id) {
        seasonRepository.deleteById(id);
    }

    public void deletarPorNome(String nameSeason) {
        seasonRepository.deleteByName(nameSeason);
    }
}
