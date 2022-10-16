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
    private String nameUsuario;

    private String email;

    private String senha;

    private String icone;

    private int nroWin;

    private int nroLose;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameUsuario() {
        return nameUsuario;
    }

    public void setNameUsuario(String nameUsuario) {
        this.nameUsuario = nameUsuario;
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