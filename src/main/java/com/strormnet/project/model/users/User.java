package com.strormnet.project.model.users;

public abstract class User {

    private Integer id;
    private String fio;
    private Integer phoneNumber;
    private String password;
    private Boolean isAdmin;

    public User() {
    }

    public User(Integer id, String fio, Integer phoneNumber, String password) {
        this.id = id;
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User(String fio, Integer phoneNumber, String password) {
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.password = password;
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
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
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
