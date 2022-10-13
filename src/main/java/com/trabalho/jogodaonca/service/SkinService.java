package com.trabalho.jogodaonca.service;

import com.trabalho.jogodaonca.model.Skin;
import com.trabalho.jogodaonca.repository.SkinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkinService {

    private SkinRepository skinRepository;

    @Autowired
    public SkinService(SkinRepository skinRepository) {
        this.skinRepository = skinRepository;
    }

    public Skin cadastrar(Skin skin) {
        return skinRepository.save(skin);
    }

    public Skin atualizar(Skin skin) {
        return skinRepository.save(skin);
    }

    public List<Skin> buscarTodos() {
        return skinRepository.findAll();
    }

    public Optional<Skin> buscarPorId(Long id) {
        return skinRepository.findById(id);
    }

    public Optional<Skin> buscarPorNome(String nome) {
        return skinRepository.findByNameSkinContainingIgnoreCase(nome);
    }

    public void deletarPorId(Long id) {
        skinRepository.deleteById(id);
    }

    public void deletarPorNome(String nameSkin) {
        skinRepository.deleteByName(nameSkin);
    }
}
