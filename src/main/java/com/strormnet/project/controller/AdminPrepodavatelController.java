package com.strormnet.project.controller;
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
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

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
    private TableView<Prepodavatel> tableView;

    @FXML
    void initialize() {
        PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
        //TODO Разобраться почему не отображает isAdmin.
        //TODO добавить демона который обновляет таблицу
        List<Prepodavatel> all = prepodavatelRepository.getAll();
        for(Prepodavatel prepodavatel : all) {
            tableView.getItems().add(prepodavatel);
            fio.setCellValueFactory(new PropertyValueFactory<Prepodavatel, String>("fio"));
            stavkaPerHour.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Integer>("stavkaPerHour"));
            experience.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Integer>("experience"));
            phoneNumber.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Integer>("phoneNumber"));
            password.setCellValueFactory(new PropertyValueFactory<Prepodavatel, String>("password"));
            isAdmin.setCellValueFactory(new PropertyValueFactory<Prepodavatel, CheckBox>("isAdmin"));
        }


    }

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
