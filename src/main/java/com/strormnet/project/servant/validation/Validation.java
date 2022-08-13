package com.strormnet.project.servant.validation;

import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.validation.Threads.GetAdminsFromDataBaseThread;
import com.strormnet.project.servant.validation.Threads.GetPrepodavatelFromDataBaseThread;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Validation {

    private List<User> users = new ArrayList<>();
    private Integer login;
    private String password;
    private User user;

    public Validation(Integer login, String password) {
        this.login = login;
        this.password = password;

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

    public <T extends User> T startValidation() throws InterruptedException {
        GetAdminsFromDataBaseThread getAdminsFromDataBaseThread = new GetAdminsFromDataBaseThread(this);
        GetPrepodavatelFromDataBaseThread getPrepodavatelFromDataBaseThread = new GetPrepodavatelFromDataBaseThread(this);
        getAdminsFromDataBaseThread.start();
        getPrepodavatelFromDataBaseThread.start();
        getPrepodavatelFromDataBaseThread.join();
        return (T) getFoundedUser();
    }

    public <T extends  User> void checkNull(T user, Label label, TextField loginField, PasswordField passwordField){
        Optional.ofNullable(user).ifPresentOrElse(gen -> {
            System.out.println("Пользователь найден " + user);
            label.setVisible(false);
            if(user.getClass().equals(Prepodavatel.class)){
                Prepodavatel prepodavatel = (Prepodavatel) user;

                //TODO реализовать передачу в ПреподМеню контроллер
            }
        }, () -> {
            System.out.println("Пользователь не найден");
            Servant.ErrorFieldStyle(false, loginField, passwordField);
            label.setVisible(true);
        });
    }

}
