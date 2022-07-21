package dto;

public class PredmetDto {
    private Integer id;
    private String nazvaniePredmeta;
    private String typePredmeta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
