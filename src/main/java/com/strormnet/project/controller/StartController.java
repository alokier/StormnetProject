package com.strormnet.project.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.strormnet.project.model.users.Admin;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.Servant;
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
    void LoginOnMousePressed(MouseEvent event) {
        LoginButton.setStyle("-fx-background-color:F39C63");

    }

    @FXML
    void LoginOnMouseReleased(MouseEvent event) {
        LoginButton.setStyle("-fx-background-color: #0ca2e1");
    }

    @FXML
    void onMouseClickedOnLoginField(MouseEvent event) {
        LoginField.setStyle(null);
    }

    @FXML
    void onMouseClickedOnPasswordField(MouseEvent event) {
        PasswordField.setStyle(null);
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
            User user = validation.startValidation();
            Optional.ofNullable(user).ifPresentOrElse(gen -> {
                System.out.println("Пользователь найден " + user);
                incorrectPassword.setVisible(false);
                if(user.getClass().equals(Prepodavatel.class)){
                    Prepodavatel prepodavatel = (Prepodavatel) user;

                    //TODO реализовать передачу в ПреподМеню контроллер
                }
            }, () -> {
                System.out.println("Пользователь не найден");
                Servant.ErrorFieldStyle(false,LoginField, PasswordField);
                incorrectPassword.setVisible(true);
            });
        } catch (NumberFormatException e) {
            incorrectPassword.setVisible(true);
            Servant.ErrorFieldStyle(false, LoginField,PasswordField);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ForgotPasswordChangeCursor(MouseEvent event) {
    forgotPassword.setCursor(Cursor.HAND);
    }

    @FXML
    void initialize() {
        LoginField.setFocusTraversable(false);
        PasswordField.setFocusTraversable(false);
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

}

