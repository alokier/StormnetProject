package com.strormnet.project.model;


import com.strormnet.project.enums.PredmetType;

public class Predmet {
    private String nazvanie;
    private PredmetType type;
    private Integer id;

    public Predmet(String nazvanie, PredmetType type) {
        this.nazvanie = nazvanie;
        this.type = type;
    }

    public Predmet(){

    }

    public String getNazvanie() {
        return nazvanie;
    }

    public void setNazvanie(String nazvanie) {
        this.nazvanie = nazvanie;
    }

    public PredmetType getType() {
        return type;
    }

    public void setType(PredmetType type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "nazvaniePredmeta='" + nazvanie + '\'' +
                ", typePredmeta='" + type + '\'' +
                '}';
    }
}
