package com.strormnet.project.model.users;

public class Prepodavatel extends User{

    private Double stavkaPerHour;
    private Integer experience;


    public Prepodavatel(Integer id, String fio, Integer phoneNumber, String password, Double stavkaPerHour, Integer experience) {
        super(id, fio, phoneNumber, password);
        this.stavkaPerHour = stavkaPerHour;
        this.experience = experience;
        setAdmin(false);
    }

    public Prepodavatel(String fio, Integer phoneNumber, String password, Double stavkaPerHour, Integer experience) {
        super(fio, phoneNumber, password);
        this.stavkaPerHour = stavkaPerHour;
        this.experience = experience;
        setAdmin(false);
    }

    public Prepodavatel() {
        setAdmin(false);
    }

    public Double getStavkaPerHour() {
        return stavkaPerHour;
    }

    public void setStavkaPerHour(Double stavkaPerHour) {
        this.stavkaPerHour = stavkaPerHour;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Prepodavatel{" +
                "id=" + getId() +
                ", fio='" + getFio() + '\'' +
                ", stavkaPerHour=" + stavkaPerHour +
                ", experience=" + experience +
                ", phoneNumber=" + getPhoneNumber() +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
