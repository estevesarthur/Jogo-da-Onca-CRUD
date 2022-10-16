/* package com.trabalho.jogodaonca.controller;

//import com.trabalho.jogodaonca.model.Usuario;
import com.trabalho.jogodaonca.model.UsuarioAdmin;
import com.trabalho.jogodaonca.service.UsuarioAdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioAdminController {

    @Autowired
    private UsuarioAdmService usuarioService;

    @PostMapping("/logar")
    public ResponseEntity<UsuarioAdmin> autentication(@RequestBody Optional<UsuarioAdmin> user) {
        return usuarioService.logar(user).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioAdmin> criar(@RequestBody UsuarioAdmin usuarioLogin) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(usuarioService.cadastrarUsuarioLogin(usuarioLogin));
    }

    //Verificar se precisa e se precisar, como colocar para guardar a primeira senha de cadastro(repetir a senha), 
    //guardar o e-mail, e do esqueci a senha
}
 */