package com.trabalho.jogodaonca.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //(strategy=GenerationType.SEQUENCE) ver a diferença
    private long id;

    @Size(max = 200)
    private String imgBanner;

    @Size(max = 45)
    private String nameBanner;
}
