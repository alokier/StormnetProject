package com.strormnet.project.servant.Validation;

import com.strormnet.project.model.users.Admin;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.Validation.Threads.GetAdminsFromDataBaseThread;
import com.strormnet.project.servant.Validation.Threads.GetPrepodavatelFromDataBaseThread;

import java.util.ArrayList;
import java.util.List;


public class Validation {

    private List<User> users = new ArrayList<>();
    private Integer login;
    private String password;
    private User user;

    public Validation(Integer login, String password) {
        this.login = login;
        this.password = password;

    }

    public <T extends User> T startValidation() throws InterruptedException {
        GetAdminsFromDataBaseThread getAdminsFromDataBaseThread = new GetAdminsFromDataBaseThread(this);
        GetPrepodavatelFromDataBaseThread getPrepodavatelFromDataBaseThread = new GetPrepodavatelFromDataBaseThread(this);
        getAdminsFromDataBaseThread.start();
        getPrepodavatelFromDataBaseThread.start();
        getPrepodavatelFromDataBaseThread.join();
        if(getFoundedUser().equals(Prepodavatel.class)){
            System.out.println("Вернул препода");
            Prepodavatel prepodavatel = getFoundedUser();
            return (T) prepodavatel;
        }
        if(getFoundedUser().equals(Admin.class)){
            System.out.println("Вернул админа");
            Admin admin = getFoundedUser();
            return (T) getFoundedUser();
        }
        return getFoundedUser();
    }


    public <T extends User> T getFoundedUser() {
        return (T) user;
    }

    public <T extends User> void setFoundedUser(T user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
