package com.trabalho.jogodaonca.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Superuser
@Entity
@Table(name = "tb_superuser")
public class UsuarioAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nomeAdmin;

    private String senha;

    private String token;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeAdmin() {
        return nomeAdmin;
    }

    public void setNomeAdmin(String nomeAdmin) {
        this.nomeAdmin = nomeAdmin;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}