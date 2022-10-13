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

    public Skin() {
    }

    public Skin(long id, @Size(max = 45) String nameSkin, @Size(max = 200) String imgSkin) {
        this.id = id;
        this.nameSkin = nameSkin;
        this.imgSkin = imgSkin;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameSkin() {
        return nameSkin;
    }

    public void setNameSkin(String nameSkin) {
        this.nameSkin = nameSkin;
    }

    public String getImgSkin() {
        return imgSkin;
    }

    public void setImgSkin(String imgSkin) {
        this.imgSkin = imgSkin;
    }

}
