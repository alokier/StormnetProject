package com.strormnet.project.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label CreateAcc;

    @FXML
    private Label forgotPassword;

    @FXML
    private Button LoginButton;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    Stage stage;

    @FXML
    protected void CreateAccountClicked(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com.stormnet.resources/CreateAccount.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 400);
        Stage stage2 = new Stage();
        stage2.setTitle("Create Account");
        stage2.setScene(scene);
        stage2.show();
        stage = (Stage) LoginButton.getScene().getWindow();
        stage.hide();
    }

    @FXML
    protected void ForgotPasswordClicked(MouseEvent event) {
        System.out.println("ForgotPAss nagata");
        //TODO Реализовать метод
    }

    @FXML
    void ForgotPasswordChangeCursor(MouseEvent event) {
    forgotPassword.setCursor(Cursor.HAND);
    }

    @FXML
    protected void ChangeCursor(MouseEvent event) {
    CreateAcc.setCursor(Cursor.HAND);
    }

    @FXML
    void initialize() {
        LoginField.setFocusTraversable(false);
        PasswordField.setFocusTraversable(false);
    }

}

