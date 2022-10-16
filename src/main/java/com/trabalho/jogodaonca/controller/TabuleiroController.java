package com.trabalho.jogodaonca.controller;

import com.trabalho.jogodaonca.model.Tabuleiro;
import com.trabalho.jogodaonca.service.TabuleiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tabuleiro")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TabuleiroController {

    private TabuleiroService tabuleiroService;

    @Autowired
    public TabuleiroController(TabuleiroService tabuleiroService) {
        this.tabuleiroService = tabuleiroService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Tabuleiro> cadastrar(@RequestBody Tabuleiro tabuleiro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tabuleiroService.cadastrar(tabuleiro));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Tabuleiro> atualizar(@RequestBody Tabuleiro tabuleiro) {
        ResponseEntity<Tabuleiro> response = null;
        if (tabuleiro.getId() != null && tabuleiroService.buscarPorId(tabuleiro.getId()).isPresent()
                || tabuleiro.getNameTabuleiro() != null
                        && tabuleiroService.buscarPorNome(tabuleiro.getNameTabuleiro()).isPresent()) {
            response = ResponseEntity.status(HttpStatus.OK).body(tabuleiroService.atualizar(tabuleiro));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<Tabuleiro>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(tabuleiroService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Tabuleiro>> buscarPorId(@PathVariable Long id) {
        ResponseEntity<Optional<Tabuleiro>> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(tabuleiroService.buscarPorId(id));
        } catch (HttpClientErrorException.NotFound ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @GetMapping("/buscar/{nameTabuleiro}")
    public ResponseEntity<Optional<Tabuleiro>> buscarPorNome(@PathVariable String nameTabuleiro) {
        ResponseEntity<Optional<Tabuleiro>> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(tabuleiroService.buscarPorNome(nameTabuleiro));
        } catch (HttpClientErrorException.NotFound ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if (tabuleiroService.buscarPorId(id).isPresent()) {
            tabuleiroService.deletarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Tabuleiro deletado com sucesso!!");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
