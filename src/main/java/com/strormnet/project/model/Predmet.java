package com.strormnet.project.model;


import com.strormnet.project.enums.PredmetType;

public class Predmet {
    private String nazvaniePredmeta;
    private PredmetType typePredmeta;
    private Integer id;

    public Predmet(String nazvaniePredmeta, PredmetType typePredmeta) {
        this.nazvaniePredmeta = nazvaniePredmeta;
        this.typePredmeta = typePredmeta;
    }

    public Predmet(){

    }

    public String getNazvaniePredmeta() {
        return nazvaniePredmeta;
    }

    public void setNazvaniePredmeta(String nazvaniePredmeta) {
        this.nazvaniePredmeta = nazvaniePredmeta;
    }

    public PredmetType getTypePredmeta() {
        return typePredmeta;
    }

    public void setTypePredmeta(PredmetType typePredmeta) {
        this.typePredmeta = typePredmeta;
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
                "nazvaniePredmeta='" + nazvaniePredmeta + '\'' +
                ", typePredmeta='" + typePredmeta + '\'' +
                '}';
    }
}
