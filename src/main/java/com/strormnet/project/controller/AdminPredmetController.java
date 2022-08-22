package com.strormnet.project.controller;
import com.strormnet.project.servant.Servant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class AdminPredmetController {
    @FXML
    private Label ProfileBackButton;

    @FXML
    private Label ProfileClickableLabel;

    @FXML
    private Button addPredmetId;

    @FXML
    private Button applyUpdateId;

    @FXML
    private Button cancelSaveID;

    @FXML
    private Button deleteButton;

    @FXML
    private Label fioLabel;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> title;

    @FXML
    private Label titleLabel;

    @FXML
    private TableColumn<?, ?> type;


    @FXML
    void CancelUpdatePrepodavatelInTableClick(ActionEvent event) {

    }

    @FXML
    void ClickOnBackButton(MouseEvent event) {
        Servant.closeScene(fioLabel);
    }

    @FXML
    void UpdatePrepodavatelInTableClick(ActionEvent event) {

    }

    @FXML
    void onActionAddPredmet(ActionEvent event) {

    }

    @FXML
    void onActionDeletePredmet(ActionEvent event) {

    }

}
