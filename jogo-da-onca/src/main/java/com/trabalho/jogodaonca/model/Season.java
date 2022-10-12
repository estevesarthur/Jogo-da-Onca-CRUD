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

    /* possibilidade de incluir numSeason
    private int numSeason; */

    @Size(max = 45)
    private String nameSeason;

    private Date inicio;

    private Date fim;

    @ManyToOne
    private Tabuleiro tabuleiroId;

    @ManyToOne
    private  Skin skinId;

}
