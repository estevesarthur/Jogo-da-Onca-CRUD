package com.trabalho.jogodaonca.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "tb_season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /*
     * possibilidade de incluir numSeason
     * private int numSeason;
     */

    @Size(max = 45)
    private String nameSeason;

    private Date inicio;

    private Date fim;

    @ManyToOne
    private Tabuleiro tabuleiroId;

    @ManyToOne
    private Skin skinId;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameSeason() {
        return nameSeason;
    }

    public void setNameSeason(String nameSeason) {
        this.nameSeason = nameSeason;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Tabuleiro getTabuleiroId() {
        return tabuleiroId;
    }

    public void setTabuleiroId(Tabuleiro tabuleiroId) {
        this.tabuleiroId = tabuleiroId;
    }

    public Skin getSkinId() {
        return skinId;
    }

    public void setSkinId(Skin skinId) {
        this.skinId = skinId;
    }

}
