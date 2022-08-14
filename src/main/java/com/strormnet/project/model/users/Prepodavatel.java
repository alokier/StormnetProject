package com.strormnet.project.model.users;

public class Prepodavatel extends User{

    private Double stavkaPerHour;
    private Integer experience;


    public Prepodavatel(Double stavkaPerHour, Integer experience) {
        this.stavkaPerHour = stavkaPerHour;
        this.experience = experience;
    }

    public Prepodavatel(Integer id, String fio, Integer phoneNumber, String password, Boolean isAdmin, Double stavkaPerHour, Integer experience) {
        super(id, fio, phoneNumber, password, isAdmin);
        this.stavkaPerHour = stavkaPerHour;
        this.experience = experience;
    }

    public Prepodavatel(String fio, Integer phoneNumber, String password, Boolean isAdmin, Double stavkaPerHour, Integer experience) {
        super(fio, phoneNumber, password, isAdmin);
        this.stavkaPerHour = stavkaPerHour;
        this.experience = experience;
    }

    public Prepodavatel() {
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
