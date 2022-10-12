package com.trabalho.jogodaonca.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_skin")
public class Skin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(max = 45)
    private String nameSkin;

    @Size(max = 200)
    private String imgSkin;

    public Long getId() {
        return id;
    }
}
