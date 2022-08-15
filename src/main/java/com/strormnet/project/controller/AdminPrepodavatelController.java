package com.strormnet.project.controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.constant.Constant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

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
    private Button addPrepId;

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

    @FXML
    void onActionAddPrep(ActionEvent event) {
        try {
            Servant.onTheNextSceneWithoutObj(Constant.ADMIN_PREP_ADD_PATH,"Add",260, 420, true, addPrepId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ClickOnBackButton(MouseEvent event) {
        Servant.closeScene(addPrepId);
    }


}
