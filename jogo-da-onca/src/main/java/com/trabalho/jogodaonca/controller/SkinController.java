package com.trabalho.jogodaonca.controller;

import com.trabalho.jogodaonca.model.Skin;
import com.trabalho.jogodaonca.model.Tabuleiro;
import com.trabalho.jogodaonca.service.SkinService;
import com.trabalho.jogodaonca.service.TabuleiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/skin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SkinController {

    private SkinService skinService;

    @Autowired
    public SkinController(SkinService skinService) {
        this.skinService = skinService;
    }

    //@RequestMapping("/skin/cadastrar") TALVEZ???
    @PostMapping
    public ResponseEntity<Skin> cadastrar(@RequestBody Skin skin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(skinService.cadastrar(skin));
    }

    @PutMapping
    public ResponseEntity<Skin> atualizar(@RequestBody Skin skin) {
        ResponseEntity<Skin> response = null;
        if (skin.getId() != null && skinService.buscarPorId(skin.getId()).isPresent()) {
            response = ResponseEntity.status(HttpStatus.OK).body(skinService.atualizar(skin));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Skin>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(skinService.buscarTodos());
    }
    //criar busca por nome e por id e nome
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Skin>> buscarPorId(@PathVariable Long id) {
        ResponseEntity<Optional<Skin>> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(skinService.buscarPorId(id));
        } catch (HttpClientErrorException.NotFound ex) {
            ex.printStackTrace();
        }
        return response;
    }
    //criar deletar por nome e por id e nome
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if (skinService.buscarPorId(id).isPresent()) {
            skinService.deletarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Skin deletada com sucesso!!");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
