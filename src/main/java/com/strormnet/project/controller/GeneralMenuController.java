package com.strormnet.project.controller;

import com.strormnet.project.model.users.Admin;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.constant.Constant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class GeneralMenuController {

    @FXML
    private Button ButtonGetGroups;

    @FXML
    private Button ButtonGetLessons;

    @FXML
    private Button ButtonStartLesson;

    @FXML
    private Label ProfileClickableLabel;

    @FXML
    private Button adminGroupsButtonId;

    @FXML
    private Label adminLabelPanelID;

    @FXML
    private Button adminPrepButtonId;

    @FXML
    private Button adminStudensButtonId;

    @FXML
    private Button exitButton;

    @FXML
    private Label fioLabel;

    private Prepodavatel prepodavatel;

    private Admin admin;

    public<T extends User> void addData(T user){
        if( user instanceof Prepodavatel){
            prepodavatel = (Prepodavatel) user;
            System.out.println(prepodavatel.getAdmin());
            fioLabel.setText(prepodavatel.getFio());

        } else {
            admin = (Admin) user;
            System.out.println(admin.getAdmin());
            fioLabel.setText(admin.getFio());
        }
        if(user instanceof Admin && user.getAdmin()){
            adminLabelPanelID.setVisible(true);
            adminGroupsButtonId.setVisible(true);
            adminStudensButtonId.setVisible(true);
            adminPrepButtonId.setVisible(true);
            ButtonStartLesson.setVisible(false);
            ButtonGetLessons.setVisible(false);
            ButtonGetGroups.setVisible(false);
        }
        else if(user instanceof Prepodavatel && user.getAdmin()){
            adminLabelPanelID.setVisible(true);
            adminGroupsButtonId.setVisible(true);
            adminStudensButtonId.setVisible(true);
            adminPrepButtonId.setVisible(true);
            ButtonStartLesson.setVisible(true);
            ButtonGetLessons.setVisible(true);
            ButtonGetGroups.setVisible(true);
        }
        else {
            ButtonStartLesson.setVisible(true);
            ButtonGetLessons.setVisible(true);
            ButtonGetGroups.setVisible(true);
            adminLabelPanelID.setVisible(false);
            adminGroupsButtonId.setVisible(false);
            adminStudensButtonId.setVisible(false);
            adminPrepButtonId.setVisible(false);
        }

    }
    /*..............Кнопка Выхода................*/
    @FXML
    void Exit(ActionEvent event) {
        Servant.closeScene(fioLabel);
    }

    /*...........*/
    @FXML
    void initialize() {

    }

    /*..............Админка..............*/

    @FXML
    void AdminGroupsButton(ActionEvent event) {

    }

    @FXML
    void AdminStudentsButton(ActionEvent event) {

    }


    @FXML
    void AdminsPrepsButton(ActionEvent event) {
        try {
            Servant.onAdminPrepScene(Constant.ADMIN_PREP_PATH,"Teachers",726,410);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*...........*/

}
