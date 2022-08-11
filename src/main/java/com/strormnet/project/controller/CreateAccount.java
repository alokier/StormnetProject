package com.strormnet.project.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CreateAccount {

@FXML
private ResourceBundle resources;

@FXML
private URL location;

@FXML
private TextField LastNameField;

@FXML
private Button LoginButton;

@FXML
private TextField LoginField;

@FXML
private Button BackButton;

@FXML
private TextField NameField;

@FXML
private PasswordField PasswordField;

Stage stage;

@FXML
void BackClicked(MouseEvent event) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.stormnet.resources/Pass.fxml"));
    Scene scene = new Scene(fxmlLoader.load(), 540, 460);
    Stage stage2 = new Stage();
    stage2.setTitle("Create Account");
    stage2.setScene(scene);
    stage2.show();
    stage = (Stage) LoginButton.getScene().getWindow();
    stage.hide();
}

    @FXML
    void initialize() {
        LoginField.setFocusTraversable(false);
        LastNameField.setFocusTraversable(false);
        NameField.setFocusTraversable(false);
        PasswordField.setFocusTraversable(false);

    }


}

