package com.trabalho.jogodaonca.model;

//Será que é o superuser
public class UsuarioLogin {

    private String nome;

    private String email;

    private String senha;

    private String token;

    public String getEmail() {
        return email;
    }

    public CharSequence getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
