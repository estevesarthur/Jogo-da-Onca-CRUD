package com.trabalho.jogodaonca.controller;

import com.trabalho.jogodaonca.model.Usuario;
import com.trabalho.jogodaonca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {

    private UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/usuario/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.cadastrar(usuario));
    }

    @PutMapping("/usuario/atualizar/{id}")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) {
        ResponseEntity<Usuario> response = null;
        if (usuario.getId() != null && usuarioService.buscarPorId(usuario.getId()).isPresent()
                || usuario.getNameUsuario() != null
                        && usuarioService.buscarPorNome(usuario.getNameUsuario()).isPresent()) {
            response = ResponseEntity.status(HttpStatus.OK).body(usuarioService.atualizar(usuario));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<Usuario>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarTodos());
    }
    
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Usuario>> buscarPorId(@PathVariable Long id) {
        ResponseEntity<Optional<Usuario>> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarPorId(id));
        } catch (HttpClientErrorException.NotFound ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @GetMapping("/buscar/{nameUsuario}")
    public ResponseEntity<Optional<Usuario>> buscarPorNome(@PathVariable String nameUsuario) {
        ResponseEntity<Optional<Usuario>> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(usuarioService.buscarPorNome(nameUsuario));
        } catch (HttpClientErrorException.NotFound ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if (usuarioService.buscarPorId(id).isPresent()) {
            usuarioService.deletarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Usuario deletado com sucesso!!");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
