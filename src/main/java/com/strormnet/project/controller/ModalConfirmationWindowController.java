package com.strormnet.project.controller;

import com.strormnet.project.servant.Servant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ModalConfirmationWindowController {

    @FXML
    private Button confirmExitId;

    @FXML
    private Label fioLabel;

    @FXML
    private Button idGeneratePassword;

    @FXML
    private Button removeExitId;

    @FXML
    private Label themeLabel;

    @FXML
    private Label titleLabel;

    private Stage stageOwner;

    @FXML
    void generatePasswordOnclick(ActionEvent event) {

    }

    @FXML
    void onClickConfirmExitId(ActionEvent event) {
        stageOwner.close();
        Servant.closeScene(themeLabel);
    }

    @FXML
    void onClickOnRemoveExit(ActionEvent event) {

    }

    public void addOwnerScene(Stage stage){
        stageOwner = stage;
    }
}
