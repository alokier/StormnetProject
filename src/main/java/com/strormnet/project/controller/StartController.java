package com.strormnet.project.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.strormnet.project.servant.Validation.Validation;
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

    @FXML
    private Label incorrectPassword;

    Stage stage;

    @FXML
    void onMouseClickedOnLoginField(MouseEvent event) {
        LoginField.setStyle(null);
    }

    @FXML
    void onMouseClickedOnPasswordField(MouseEvent event) {
        PasswordField.setStyle(null);
    }

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
    void onClickedValidation(MouseEvent event) {
        try{
            Validation validation = new Validation(Integer.parseInt(LoginField.getText()),PasswordField.getText());
            validation.startValidation();
        } catch (NumberFormatException e) {
            incorrectPassword.setVisible(true);
            LoginField.setText("");
            LoginField.setStyle("-fx-border-color:red");
            PasswordField.setText("");
            PasswordField.setStyle("-fx-border-color:red");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

