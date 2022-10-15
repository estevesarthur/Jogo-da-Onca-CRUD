package com.trabalho.jogodaonca.controller;

import com.trabalho.jogodaonca.model.Banner;
import com.trabalho.jogodaonca.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/banner")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BannerController {
    private BannerService bannerService;

    @Autowired
    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }

    @RequestMapping("/cadastrar")
    @PostMapping
    public ResponseEntity<Banner> cadastrar(@RequestBody Banner banner) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bannerService.cadastrar(banner));
    }

    @RequestMapping("/atualizar")
    @PutMapping
    public ResponseEntity<Banner> atualizar(@RequestBody Banner banner) {
        ResponseEntity<Banner> response = null;
        if (banner.getId() != null && bannerService.buscarPorId(banner.getId()).isPresent()
                || banner.getNameBanner() != null && bannerService.buscarPorNome(banner.getNameBanner()).isPresent()) {
            response = ResponseEntity.status(HttpStatus.OK).body(bannerService.atualizar(banner));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @RequestMapping("/buscar/todos")
    @GetMapping
    public ResponseEntity<List<Banner>> buscarTodos() {
        return ResponseEntity.status(HttpStatus.OK).body(bannerService.buscarTodos());
    }

    @RequestMapping("/buscar/id")
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Banner>> buscarPorId(@PathVariable Long id) {
        ResponseEntity<Optional<Banner>> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(bannerService.buscarPorId(id));
        } catch (HttpClientErrorException.NotFound ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @RequestMapping("/buscar/nome")
    @GetMapping("/{nameBanner}")
    public ResponseEntity<Optional<Banner>> buscarPorNome(@PathVariable String nameBanner) {
        ResponseEntity<Optional<Banner>> response = null;
        try {
            response = ResponseEntity.status(HttpStatus.OK).body(bannerService.buscarPorNome(nameBanner));
        } catch (HttpClientErrorException.NotFound ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @RequestMapping("/deletar/id")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if (bannerService.buscarPorId(id).isPresent()) {
            bannerService.deletarPorId(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Banner deletado com sucesso!!");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
}
