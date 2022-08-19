package com.strormnet.project.model.users;

import java.io.Serializable;

public abstract class User implements Serializable {

    private Integer id;
    private String fio;
    private Integer phoneNumber;
    private transient String password;
    private Boolean admin;

    public User() {
    }

    public User(Integer id, String fio, Integer phoneNumber, String password, Boolean isAdmin) {
        this.id = id;
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.admin = isAdmin;
    }

    public User(String fio, Integer phoneNumber, String password, Boolean isAdmin) {
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.admin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", password='" + password + '\'' +
                '}';
    }
}
