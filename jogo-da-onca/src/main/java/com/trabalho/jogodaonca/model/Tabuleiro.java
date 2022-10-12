package com.trabalho.jogodaonca.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tabuleiro")
public class Tabuleiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 200)
    private String imgTabuleiro;

    @Size(max = 45)
    private String nameTabuleiro;

    public Long getId() {
        return id;
    }
}
