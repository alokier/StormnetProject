package com.strormnet.project.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Stream;

import com.strormnet.project.dao.impl.PrepodavatelRepositoryImpl;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.constant.Constant;

import com.strormnet.project.servant.updateThreads.UpdateDemonThread;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;


public class AdminPrepodavatelController {

    @FXML
    private Button applyUpdateId;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label ProfileBackButton;

    @FXML
    private Label ProfileClickableLabel;

    @FXML
    private Button addPrepId;

    @FXML
    private Button deleteButton;

    @FXML
    private Label fioLabel;

    @FXML
    private Label prepodavatelsLabel;

    @FXML
    private Button resetPassword;

    @FXML
    private Label titleLabel;

    @FXML
    private TableColumn<Prepodavatel, Integer> experience;

    @FXML
    private TableColumn<Prepodavatel, String> fio;

    @FXML
    private TableColumn<Prepodavatel, CheckBox> isAdmin;

    @FXML
    private TableColumn<Prepodavatel, String> password;

    @FXML
    private TableColumn<Prepodavatel, Integer> phoneNumber;

    @FXML
    private TableColumn<Prepodavatel, Integer> stavkaPerHour;

    @FXML
    private Button cancelSaveID;

    @FXML
    private TableView<Prepodavatel> tableView;

    private UpdateDemonThread updateDemonThread = new UpdateDemonThread();

    @FXML
    void initialize() {
        PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
        //TODO Разобраться почему не отображает isAdmin.
        //TODO добавить демона который обновляет таблицу
        String s = addPrepId.getText();
        List<Prepodavatel> all = prepodavatelRepository.getAll();
        tableView.getItems().addAll(all);
        fio.setCellValueFactory(new PropertyValueFactory<Prepodavatel, String>("fio"));
        stavkaPerHour.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Integer>("stavkaPerHour"));
        experience.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Integer>("experience"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Integer>("phoneNumber"));
        password.setCellValueFactory(new PropertyValueFactory<Prepodavatel, String>("password"));
        isAdmin.setCellValueFactory(new PropertyValueFactory<Prepodavatel, CheckBox>("admin"));
        updateDemonThread.setTableView(tableView);
        updateDemonThread.start();

        fio.setCellFactory(TextFieldTableCell.<Prepodavatel>forTableColumn());
        fio.setOnEditCommit(
                (TableColumn.CellEditEvent<Prepodavatel, String> t) -> {
                    ((Prepodavatel) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setFio(t.getNewValue());
                    applyUpdateId.setVisible(true);
                });

    }

    @FXML
    void onActionAddPrep(ActionEvent event) {
        try {
            Servant.onTheNextSceneWithoutObj(Constant.ADMIN_PREP_ADD_PATH,"Add",260, 420, true, addPrepId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*Разрешить обновить запись из таблицы и отменить запись в базу из таблицы*/
    @FXML
    void UpdatePrepodavatelInTableClick(ActionEvent event) {

    }

    @FXML
    void CancelUpdatePrepodavatelInTableClick(ActionEvent event) {

    }
    /*Конец обновления и отмены */


    @FXML
    void ClickOnBackButton(MouseEvent event) {
        Servant.closeScene(addPrepId);
    }

    @FXML
    void onActionDeletePrep(ActionEvent event) {
        try {
            PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Удалить преподавателя");
            alert.setHeaderText("Вы уверены что хотите удалить выбранного преподавателя?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == null) {
                alert.close();
            } else if (option.get() == ButtonType.OK) {
                Prepodavatel prepodavatel = tableView.getSelectionModel().getSelectedItem();
                prepodavatelRepository.deleteById(prepodavatel.getId());
            } else if (option.get() == ButtonType.CANCEL) {
                alert.close();
            } else {
                alert.close();
            }
        } catch (RuntimeException e){
            Servant.createAlert("Пользователь не выбран", "Пользователь не выбран!", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    void onActionResetPassword(ActionEvent event) {
        try {
            PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Сбросить пароль");
            alert.setHeaderText("Вы уверены что хотите сбросить пароль у выбранного преподавателя?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == null) {
                alert.close();
            } else if (option.get() == ButtonType.OK) {
                Prepodavatel prepodavatel = tableView.getSelectionModel().getSelectedItem();
                String newPassword = Servant.readResetToPassword(Constant.OTHER_INFO_PATH);
                prepodavatelRepository.resetPassword(prepodavatel.getId(), newPassword);
                updateDemonThread.setResetPassword(true);
            } else if (option.get() == ButtonType.CANCEL) {
                alert.close();
            } else {
                alert.close();
            }
        } catch (RuntimeException e){
            Servant.createAlert("Пользователь не выбран", "Пользователь не выбран!", Alert.AlertType.INFORMATION);
        } catch (FileNotFoundException e) {
            PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
            Prepodavatel prepodavatel = tableView.getSelectionModel().getSelectedItem();
            String newPassword = "password";
            prepodavatelRepository.resetPassword(prepodavatel.getId(), newPassword);
        }
    }

}
