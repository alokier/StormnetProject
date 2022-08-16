package com.strormnet.project.servant.validation;


import com.strormnet.project.model.users.User;

import com.strormnet.project.servant.validation.Threads.GetAdminsFromDataBaseThread;
import com.strormnet.project.servant.validation.Threads.GetPrepodavatelFromDataBaseThread;

import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;


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

    public static <T extends TextField> void removeText(T tf, Integer maxLength) {
        //TODO Уточнить как это лучше сделать
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([1-9][0-9]*)?")) {
                return change;
            }
            return null;
        };

//    public static <T extends TextField> void checkNullFields(Boolean clearFields, T...fields){
//            Servant.ClearErrorFieldStyle(fields);
        //TODO Сделать валидацию всех полей

//            Arrays.stream(fields).forEach(field -> {
//                if(field.getText().equals(null) || field.getText() == "") {
//                    field.setStyle("-fx-border-color:red");
//                }
//                if(clearFields){
//                    field.setText("");
//                }
//            });
    }
}

