package com.strormnet.project.model.users;

public class Admin extends User{

    public Admin(Integer id, String fio, Integer phoneNumber, String password) {
        super(id, fio, phoneNumber, password);
        setAdmin(true);
    }

    public Admin() {
        setAdmin(true);
    }

    public Admin(String fio, Integer phoneNumber, String password) {
        super(fio, phoneNumber, password);
        setAdmin(true);
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
