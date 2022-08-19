package com.strormnet.project.controller;
import com.strormnet.project.StormnetProject;
import com.strormnet.project.dao.impl.PredmetRepositoryImpl;
import com.strormnet.project.dao.impl.PrepodavatelRepositoryImpl;
import com.strormnet.project.enums.PredmetType;
import com.strormnet.project.model.Predmet;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.constant.Constant;
import com.strormnet.project.servant.nextScene.ToModalConfirmWindowFromPrepAddController;
import com.strormnet.project.servant.validation.Validation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    void onlyNumberInStavka(KeyEvent event) {
    Validation.validateText(idStavkaPerHourId, 6, true);
    }

    @FXML
    void onlyNumber(KeyEvent event) {
    Validation.validateText(idPhoneNumber,9, false);
    }

    @FXML
    void onlyNumberInExp(KeyEvent event) {
        Validation.validateText(idExpButton,2, false);
    }


    @FXML
    void onActionAddPrep(ActionEvent event) {
        Boolean aBoolean = Validation.checkNullFields(false, true, idFioField, idStavkaPerHourId, idExpButton, idPhoneNumber, idPasswordButton);
        if(!aBoolean){
            try {
                PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
                prepodavatelRepository.insertOne(new Prepodavatel(idFioField.getText(),Integer.parseInt(idPhoneNumber.getText()), idPasswordButton.getText(), idIsAdminButton.isSelected(),Double.parseDouble(idStavkaPerHourId.getText()), Integer.parseInt(idExpButton.getText())));
                Servant.createAlert("Результат", "Пользователь был добавлен!", Alert.AlertType.INFORMATION);
                System.out.println("Пользователь добавлен");
                Servant.closeScene(idIsAdminButton);

            } catch (NumberFormatException e){
                Servant.createAlert("Ошибка!", "Проверьте введённые данные!", Alert.AlertType.ERROR);
            } catch (Exception e){
                Servant.createAlert("Ошибка!", "Проверьте введённые данные!", Alert.AlertType.ERROR);
            }
        } else {
            checkAllFieldsLabel.setVisible(true);
        }
        //TODO сделать добавить пользователя в базу данных
    }

    @FXML
    void generatePasswordOnclick(ActionEvent event) {
        idPasswordButton.setText(Servant.generatePassword(10));
    }

    @FXML
    void onClickedProfileBackButton(MouseEvent event) {
        Boolean aBoolean = Validation.checkNullFields(false,false, idFioField, idStavkaPerHourId, idExpButton, idPhoneNumber, idPasswordButton);
        if(!aBoolean) {
            Servant.closeScene(idIsAdminButton);
        } else {
            try {
                ToModalConfirmWindowFromPrepAddController.onTheNextSceneWithStage(Constant.MODAL_CONFIRM_WINDOW_PATH, "Confirmation window", Servant.getCurrentStage(titleLabel), 275, 210, true, titleLabel);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
