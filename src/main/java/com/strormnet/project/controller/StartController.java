package com.strormnet.project.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.strormnet.project.model.users.Admin;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.constant.Constant;
import com.strormnet.project.servant.nextScene.ToGeneralMenuControllerFromStart;
import com.strormnet.project.servant.validation.Validation;
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
    private Label titleLabel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    protected void ForgotPasswordClicked(MouseEvent event) {
        System.out.println("ForgotPAss nagata");
        //TODO Реализовать метод
    }

    @FXML
    void onClickedValidation(MouseEvent event) {
        try {
            Validation validation = new Validation(Integer.parseInt(LoginField.getText()), PasswordField.getText());
            User user = validation.startValidation();
            Optional.ofNullable(user).ifPresentOrElse(val -> {
                if (user instanceof Prepodavatel) {
                    Prepodavatel prepodavatel = (Prepodavatel) user;
                    try {
                        ToGeneralMenuControllerFromStart.onNextScene(Constant.GENERAL_MENU_PATH, "Menu", prepodavatel, 726, 410);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Servant.closeScene(forgotPassword);
                }
                if (user instanceof Admin) {
                    Admin admin = (Admin) user;
                    try {
                        ToGeneralMenuControllerFromStart.onNextScene(Constant.GENERAL_MENU_PATH, "Menu", admin, 726, 410);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    Servant.closeScene(forgotPassword);
                }
            }, () -> {
                System.out.println("Пользователь не найден");
                Servant.ErrorFieldStyle(false, LoginField, PasswordField);
                incorrectPassword.setVisible(true);
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
            Servant.ErrorFieldStyle(false, LoginField, PasswordField);
            incorrectPassword.setVisible(true);
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
}

