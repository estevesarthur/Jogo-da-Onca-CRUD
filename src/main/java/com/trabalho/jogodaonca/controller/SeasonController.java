package com.trabalho.jogodaonca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import com.trabalho.jogodaonca.model.Season;
import com.trabalho.jogodaonca.service.SeasonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/season")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SeasonController {
    private SeasonService seasonService;

    @Autowired
    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Season> cadastrar(@RequestBody Season season) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seasonService.cadastrar(season));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Season> atualizar(@RequestBody Season season) {
        ResponseEntity<Season> response = null;
        if (season.getId() != null && seasonService.buscarPorId(season.getId()).isPresent()
                || season.getNameSeason() != null && seasonService.buscarPorNome(season.getNameSeason()).isPresent()) {
            response = ResponseEntity.status(HttpStatus.OK).body(seasonService.atualizar(season));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping("/buscar/todos")
    public ResponseEntity<List<Season>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(seasonService.buscarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Season>> buscarPorId(@PathVariable Long id) {
        ResponseEntity<Optional<Season>> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(seasonService.buscarPorId(id));
        } catch (HttpClientErrorException.NotFound ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @GetMapping("/buscar/{nameSeason}")
    public ResponseEntity<Optional<Season>> buscarPorNome(@PathVariable String nameSeason) {
        ResponseEntity<Optional<Season>> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(seasonService.buscarPorNome(nameSeason));
        } catch (HttpClientErrorException.NotFound ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarporId(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if (seasonService.buscarPorId(id).isPresent()) {
            seasonService.deletarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Season deletada com sucesso!!");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
