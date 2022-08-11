package com.strormnet.project.servant.Validation;

import com.strormnet.project.model.users.Admin;
import com.strormnet.project.model.users.Prepodavatel;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    private List<Admin> admins = new ArrayList<>();
    private List<Prepodavatel> prepodavatels = new ArrayList<>();
    private Integer login;
    private String password;

    public Validation(Integer login, String password) {
        this.login = login;
        this.password = password;
    }

    public void putAdmin(Admin admin){
        admins.add(admin);
    }

    public void putPrepodavatel(Prepodavatel prepodavatel){
        prepodavatels.add(prepodavatel);
    }

    public Boolean test(){
        return admins.stream().anyMatch(gen -> gen.getPhoneNumber().equals(login) && gen.getPassword().equals(password));
    }

    public List<Admin> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Admin> admins) {
        this.admins = admins;
    }

    public List<Prepodavatel> getPrepodavatels() {
        return prepodavatels;
    }

    public void setPrepodavatels(List<Prepodavatel> prepodavatels) {
        this.prepodavatels = prepodavatels;
    }
}
