package com.strormnet.project.controller;
import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.constant.Constant;
import com.strormnet.project.servant.nextScene.ToModalConfirmWindowFromPrepAddController;
import com.strormnet.project.servant.validation.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AdminPrepodavatelModalAdd {

    @FXML
    private Label checkAllFieldsLabel;

    @FXML
    private Label ProfileBackButton;

    @FXML
    private Button addPrepId;

    @FXML
    private Label fioLabel;

    @FXML
    private TextField idExpButton;

    @FXML
    private TextField idFioField;

    @FXML
    private Button idGeneratePassword;

    @FXML
    private CheckBox idIsAdminButton;

    @FXML
    private TextField idPasswordButton;

    @FXML
    private TextField idPhoneNumber;

    @FXML
    private TextField idStavkaPerHourId;

    @FXML
    private Label themeLabel;

    @FXML
    private Label titleLabel;

    @FXML
    void onActionAddPrep(ActionEvent event) {
        Validation.checkNullFields(false, idFioField,idStavkaPerHourId,idExpButton,idPhoneNumber,idPasswordButton);
        checkAllFieldsLabel.setVisible(true);
        //TODO сделать добавить пользователя в базу данных
    }

    @FXML
    void generatePasswordOnclick(ActionEvent event) {
        idPasswordButton.setText(Servant.generatePassword(10));
    }

    @FXML
    void onClickedProfileBackButton(MouseEvent event) {
        try {
            ToModalConfirmWindowFromPrepAddController.onTheNextSceneWithStage(Constant.MODAL_CONFIRM_WINDOW_PATH,"Confirmation window",Servant.getCurrentStage(titleLabel),275,210,true,titleLabel);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Servant.closeScene(ProfileBackButton);
    }
}
