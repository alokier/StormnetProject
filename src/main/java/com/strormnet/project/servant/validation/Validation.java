package com.strormnet.project.servant.validation;


import com.strormnet.project.model.users.User;

import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.validation.Threads.GetAdminsFromDataBaseThread;
import com.strormnet.project.servant.validation.Threads.GetPrepodavatelFromDataBaseThread;

import com.strormnet.project.servant.validation.validationable.Validationable;
import javafx.scene.control.TextField;


import java.util.ArrayList;
import java.util.Arrays;
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

    public static <T extends TextField> void validateText(T tf, Integer maxLength, Boolean decimals) {
        if(!decimals){
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
                tf.end();
            }
            if (!tf.getText().matches("\\d*")) {
                tf.setText(tf.getText().replaceAll("[^\\d]", ""));
            }
        }
        else {
            if (tf.getText().length() > maxLength) {
                String s = tf.getText().substring(0, maxLength);
                tf.setText(s);
                tf.end();
            }
            if (!tf.getText().matches("(\\d*)([.,])(\\d{2})")) {
                tf.setText(tf.getText().replaceAll("[^.,\\d]", ""));
                tf.end();
            }
            if (tf.getText().length() == maxLength && !tf.getText().matches("(\\d*)([.,])(\\d{2})")){
                tf.setText("");
                tf.end();
            }
        }
    }

    private static <T extends TextField> Validationable chooseOfBehavior(Boolean mustBeNull, T... fields) {
        if (mustBeNull) {
            return (a) -> Arrays.stream(fields).anyMatch(field -> field.getText().equals(null) || field.getText().equals(""));
        } else {
            return (a) -> Arrays.stream(fields).anyMatch(field -> !field.getText().equals(""));
            }
        }



    public static <T extends TextField> Boolean checkNullFields(Boolean clearFields, Boolean notBeNull, T... fields) {
        Servant.ClearErrorFieldStyle(fields);
        Boolean test = null;
        Boolean aBoolean = chooseOfBehavior(notBeNull, fields).checkFields(test);
        System.out.println(aBoolean);
        if (aBoolean && notBeNull){
            Arrays.stream(fields).forEach(field -> {
                if (field.getText().equals(null) || field.getText().equals("")) {
                    field.setStyle("-fx-border-color:red");
                }
                if (clearFields) {
                    field.setText("");
                }
            });
            return aBoolean;
        } else {
            return aBoolean;
        }
    }
}



