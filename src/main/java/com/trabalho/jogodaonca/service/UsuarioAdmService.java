package com.trabalho.jogodaonca.service;

//import com.trabalho.jogodaonca.model.Usuario;
import com.trabalho.jogodaonca.model.UsuarioAdmin;
import com.trabalho.jogodaonca.repository.UsuarioAdminRepository;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.Optional;

@Service
public class UsuarioAdmService {

    @Autowired
    private UsuarioAdminRepository usuarioRepository;

    public UsuarioAdmin cadastrarUsuarioLogin(UsuarioAdmin usuarioLogin) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String senhaEncoder = encoder.encode(usuarioLogin.getSenha());
        usuarioLogin.setSenha(senhaEncoder);

        return usuarioRepository.save(usuarioLogin);
    }

    
    public Optional<UsuarioAdmin> logar(Optional<UsuarioAdmin> user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<UsuarioAdmin> usuarioLogin = usuarioRepository.findByNomeAdmin(user.get().getNomeAdmin());

        if (usuarioLogin.isPresent()) {
            if (encoder.matches(user.get().getSenha(), usuarioLogin.get().getSenha())) {

                String auth = user.get().getNomeAdmin() + ":" + user.get().getSenha();
                byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodedAuth);

                user.get().setToken(authHeader);
                user.get().setNomeAdmin(usuarioLogin.get().getNomeAdmin());
                user.get().setSenha(usuarioLogin.get().getSenha());

                return user;
            }
        }
        return null;
    }
}