package com.trabalho.jogodaonca.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 45)
    private String nome;

    private String email;

    private String senha;

    private String icone;

    private int nroWin;

    private int nroLose;

    public Usuario() {
    }

    public Usuario(long id, @Size(max = 45) String nome, String email, String senha, String icone, int nroWin,
            int nroLose) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.icone = icone;
        this.nroWin = nroWin;
        this.nroLose = nroLose;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public int getNroWin() {
        return nroWin;
    }

    public void setNroWin(int nroWin) {
        this.nroWin = nroWin;
    }

    public int getNroLose() {
        return nroLose;
    }

    public void setNroLose(int nroLose) {
        this.nroLose = nroLose;
    }

}
