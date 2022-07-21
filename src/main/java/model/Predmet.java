package model;

public class Predmet {
    private String nazvaniePredmeta;
    private String typePredmeta;

    public Predmet(String nazvaniePredmeta, String typePredmeta) {
        this.nazvaniePredmeta = nazvaniePredmeta;
        this.typePredmeta = typePredmeta;
    }

    public String getNazvaniePredmeta() {
        return nazvaniePredmeta;
    }

    public void setNazvaniePredmeta(String nazvaniePredmeta) {
        this.nazvaniePredmeta = nazvaniePredmeta;
    }

    public String getTypePredmeta() {
        return typePredmeta;
    }

    public void setTypePredmeta(String typePredmeta) {
        this.typePredmeta = typePredmeta;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "nazvaniePredmeta='" + nazvaniePredmeta + '\'' +
                ", typePredmeta='" + typePredmeta + '\'' +
                '}';
    }
}
