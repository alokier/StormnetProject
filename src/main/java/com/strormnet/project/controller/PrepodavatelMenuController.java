package com.strormnet.project.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.model.users.User;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class PrepodavatelMenuController {

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
    private Label ProfileClickableLabel1;

    @FXML
    private Label ProfileClickableLabel2;

    @FXML
    private Button exitButton;

    private Prepodavatel prepodavatel;

    public void addData(Prepodavatel user){
        prepodavatel = user;
    }
    //TODO реализовать логику класса
}
