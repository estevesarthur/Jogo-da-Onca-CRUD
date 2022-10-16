package com.trabalho.jogodaonca.service;

import com.trabalho.jogodaonca.model.Usuario;
import com.trabalho.jogodaonca.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario cadastrar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorNome(String nameUsuario) {
        return usuarioRepository.findByNameUsuarioContainingIgnoreCase(nameUsuario);
    }

    public void deletarPorId(Long id) {
        usuarioRepository.deleteById(id);
    }
}
