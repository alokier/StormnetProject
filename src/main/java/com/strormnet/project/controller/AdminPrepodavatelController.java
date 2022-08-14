package com.strormnet.project.controller;
import java.net.URL;
import java.util.ResourceBundle;

import com.strormnet.project.model.users.Admin;
import com.strormnet.project.model.users.Prepodavatel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class AdminPrepodavatelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ProfileBackButton;

    @FXML
    private Label ProfileBackButton1;

    @FXML
    private Label ProfileClickableLabel;

    @FXML
    private Label ProfileClickableLabel1;

    @FXML
    private Label ProfileClickableLabel2;

    @FXML
    private Button addPrepId;

    @FXML
    private Button exitButton;

    @FXML
    private TableColumn<?, ?> experience;

    @FXML
    private TableColumn<?, ?> fio;

    @FXML
    private TableColumn<?, ?> isAdmin;

    @FXML
    private TableColumn<?, ?> password;

    @FXML
    private TableColumn<?, ?> phoneNumber;

    @FXML
    private TableColumn<?, ?> stavkaPerHour;

    private Prepodavatel prepodavatel;

    private Admin admin;

    @FXML
    void onActionAddPrep(ActionEvent event) {

    }
}
