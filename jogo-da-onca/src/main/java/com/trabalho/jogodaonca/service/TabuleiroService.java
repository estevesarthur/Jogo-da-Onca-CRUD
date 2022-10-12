package com.trabalho.jogodaonca.service;

import com.trabalho.jogodaonca.model.Tabuleiro;
import com.trabalho.jogodaonca.repository.TabuleiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TabuleiroService {

    private TabuleiroRepository tabuleiroRepository;

    @Autowired
    public TabuleiroService(TabuleiroRepository tabuleiroRepository) {
        this.tabuleiroRepository = tabuleiroRepository;
    }

    public Tabuleiro cadastrar(Tabuleiro tabuleiro) {
        return tabuleiroRepository.save(tabuleiro);
    }

    public List<Tabuleiro> buscarTodos() {
        return tabuleiroRepository.findAll();
    }

    public Optional<Tabuleiro> buscarPorId(Long id) {
        return tabuleiroRepository.findById(id);
    }

    public void deletarPorId(Long id){
        tabuleiroRepository.deleteById(id);
    }

    public Tabuleiro atualizar(Tabuleiro tabuleiro) {
        return tabuleiroRepository.save(tabuleiro);
    }

    public Optional<Tabuleiro> buscarPorNome(String nome) {
        return tabuleiroRepository.findByNameTabuleiroContainingIgnoreCase(nome);
    }
}
