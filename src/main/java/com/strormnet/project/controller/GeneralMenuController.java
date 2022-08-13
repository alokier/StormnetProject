package com.strormnet.project.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.strormnet.project.model.users.Admin;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.model.users.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class GeneralMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ButtonGetLessons;

    @FXML
    private Button ButtonGetLessons1;

    @FXML
    private Button ButtonStartLesson;

    @FXML
    private Label ProfileClickableLabel;

    @FXML
    private Button exitButton;

    @FXML
    private Label fioLabel;

    private Prepodavatel prepodavatel;

    private Admin admin;

    public<T extends User> void addData(T user){
        if(user.getClass().equals(Prepodavatel.class)){
            prepodavatel = (Prepodavatel) user;
        } else {
            admin = (Admin) user;
        }
    }

    @FXML
    void initialize() {
        System.out.println(prepodavatel);
        System.out.println(admin);
        fioLabel.setText(prepodavatel.getFio());

    }
}
