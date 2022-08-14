package com.strormnet.project.model.users;

public class Admin extends User{

    public Admin() {
    }

    public Admin(Integer id, String fio, Integer phoneNumber, String password, Boolean isAdmin) {
        super(id, fio, phoneNumber, password, isAdmin);
    }

    public Admin(String fio, Integer phoneNumber, String password, Boolean isAdmin) {
        super(fio, phoneNumber, password, isAdmin);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + getId() +
                ", fio='" + getFio() + '\'' +
                ", phoneNumber=" + getPhoneNumber() +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
