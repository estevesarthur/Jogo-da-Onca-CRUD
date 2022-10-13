package com.trabalho.jogodaonca.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // (strategy=GenerationType.SEQUENCE) ver a diferença
    private long id;

    @Size(max = 200)
    private String imgBanner;

    @Size(max = 45)
    private String nameBanner;

    public Banner() {
    }

    public Banner(long id, @Size(max = 200) String imgBanner, @Size(max = 45) String nameBanner) {
        this.id = id;
        this.imgBanner = imgBanner;
        this.nameBanner = nameBanner;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public String getNameBanner() {
        return nameBanner;
    }

    public void setNameBanner(String nameBanner) {
        this.nameBanner = nameBanner;
    }

}
