package com.strormnet.project.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import com.strormnet.project.servant.stringConvertors.ExperienceCustomIntegerStringConverter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Stream;
import com.strormnet.project.dao.impl.PrepodavatelRepositoryImpl;
import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.constant.Constant;
import com.strormnet.project.servant.stringConvertors.PhoneNumberCustomIntegerStringConverter;
import com.strormnet.project.servant.stringConvertors.StavkaPerHourCustomDoubleStringConverter;
import com.strormnet.project.servant.updateThreads.UpdateDemonThread;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;


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
    private TableColumn<Prepodavatel, Boolean> isAdmin;

    @FXML
    private TableColumn<Prepodavatel, String> password;

    @FXML
    private TableColumn<Prepodavatel, Integer> phoneNumber;

    @FXML
    private TableColumn<Prepodavatel, Double> stavkaPerHour;

    @FXML
    private Button cancelSaveID;

    @FXML
    private TableView<Prepodavatel> tableView;

    private UpdateDemonThread updateDemonThread = new UpdateDemonThread();

    private List<Prepodavatel> all;

    @FXML
    void initialize() {
        PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
        //TODO Разобраться почему не отображает isAdmin.
        String s = addPrepId.getText();
        all = prepodavatelRepository.getAll();
        tableView.getItems().addAll(all);
        fio.setCellValueFactory(new PropertyValueFactory<Prepodavatel, String>("fio"));
        stavkaPerHour.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Double>("stavkaPerHour"));
        experience.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Integer>("experience"));
        phoneNumber.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Integer>("phoneNumber"));
        password.setCellValueFactory(new PropertyValueFactory<Prepodavatel, String>("password"));
        isAdmin.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Boolean>("admin"));
        updateDemonThread.setTableView(tableView);
        updateDemonThread.start();
        setupFioColumn();
        setupStavkaPerHour();
        setupExperienceColumn();
        setupPhoneNumberColumn();
        setupAdminColumn();
        //TODO Сделать редактирование других колонок


    }

    private void setupFioColumn() {
        fio.setCellFactory(TextFieldTableCell.<Prepodavatel>forTableColumn());
        fio.setOnEditCommit(
                (TableColumn.CellEditEvent<Prepodavatel, String> t) -> {
                    ((Prepodavatel) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                    ).setFio(t.getNewValue());
                    Servant.setVisibility(true, applyUpdateId, cancelSaveID);
                });
    }
    private void setupStavkaPerHour(){
        stavkaPerHour.setCellFactory(TextFieldTableCell.<Prepodavatel, Double>forTableColumn(new StavkaPerHourCustomDoubleStringConverter(tableView)));
        stavkaPerHour.setOnEditCommit(event -> {
            ((Prepodavatel) event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
            ).setStavkaPerHour(event.getNewValue());
            Servant.setVisibility(true, applyUpdateId, cancelSaveID);
        });
    }
    private void setupExperienceColumn() {
        experience.setCellFactory(TextFieldTableCell.<Prepodavatel, Integer>forTableColumn(new ExperienceCustomIntegerStringConverter(tableView)));
        experience.setOnEditCommit(event -> {
            ((Prepodavatel) event.getTableView().getItems().get(
                    event.getTablePosition().getRow())
            ).setExperience(event.getNewValue());
            Servant.setVisibility(true, applyUpdateId, cancelSaveID);
        });
    }

    private void setupPhoneNumberColumn(){
        phoneNumber.setCellFactory(TextFieldTableCell.<Prepodavatel, Integer>forTableColumn(new PhoneNumberCustomIntegerStringConverter(tableView)));
        phoneNumber.setOnEditCommit(event -> {
                ((Prepodavatel) event.getTableView().getItems().get(
                        event.getTablePosition().getRow())
                ).setExperience(event.getNewValue());
            Servant.setVisibility(true, applyUpdateId, cancelSaveID);
        });
    }
  private void setupAdminColumn() {

      isAdmin.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Boolean>("admin"));
      final Callback<TableColumn<Prepodavatel, Boolean>, TableCell<Prepodavatel, Boolean>> cellFactory = CheckBoxTableCell.forTableColumn(isAdmin);
      isAdmin.setCellFactory(new Callback<TableColumn<Prepodavatel, Boolean>, TableCell<Prepodavatel, Boolean>>() {
          @Override
          public TableCell<Prepodavatel, Boolean> call(TableColumn<Prepodavatel, Boolean> column) {
              TableCell<Prepodavatel, Boolean> cell = cellFactory.call(column);
              cell.setAlignment(Pos.CENTER);
              return cell;
          }
      });
      isAdmin.setCellValueFactory(new PropertyValueFactory<Prepodavatel, Boolean>("admin"));
      isAdmin.setCellFactory(cellFactory);
      isAdmin.setEditable(true);

      isAdmin.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Prepodavatel,Boolean>>() {
          @Override
          public void handle(TableColumn.CellEditEvent<Prepodavatel, Boolean> event) {
              System.out.println("Edit commit");
          }
      });
  }
    @FXML
    void onActionAddPrep(ActionEvent event) {
        try {
            Servant.onTheNextSceneWithoutObj(Constant.ADMIN_PREP_ADD_PATH, "Add", 260, 420, true, addPrepId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*обновить запись из таблицы и отменить запись в базу из таблицы*/
    @FXML
    void UpdatePrepodavatelInTableClick(ActionEvent event) {
        try{
            PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
            Prepodavatel selectedItem = tableView.getSelectionModel().getSelectedItem();
            prepodavatelRepository.update(selectedItem);
            Servant.createAlert("Пользователь обновлён", "Выбранный пользователь был обновлён", Alert.AlertType.INFORMATION);
        } catch (RuntimeException e) {
            Servant.createAlert("Ошибка", "Объект не выбран, или редактирование не завершено", Alert.AlertType.INFORMATION);
        }

        //TODO Сделать обновление по нажатию на кнопку
    }

    @FXML
    void CancelUpdatePrepodavatelInTableClick(ActionEvent event) {
        try {
            PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
            List<Prepodavatel> all = prepodavatelRepository.getAll();
            Prepodavatel selectedItem = tableView.getSelectionModel().getSelectedItem();
            Prepodavatel prepodavatel1 = Stream.of(all)
                    .flatMap(gen -> gen.stream()
                    .filter(prepodavatel -> Objects.equals(prepodavatel.getId(), selectedItem.getId())))
                    .findAny().get();
            tableView.getItems().set(tableView.getSelectionModel().getSelectedIndex(), prepodavatel1);
        } catch (RuntimeException e) {
            Servant.createAlert("Ошибка", "Объект не выбран, или редактирование не завершено", Alert.AlertType.INFORMATION);
        }
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
        } catch (RuntimeException e) {
            Servant.createAlert("Пользователь не выбран", "Пользователь не выбран!", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    void onActionResetPassword(ActionEvent event) throws FileNotFoundException {
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
        }catch (RuntimeException e) {
            Servant.createAlert("Пользователь не выбран", "Пользователь не выбран!", Alert.AlertType.INFORMATION);
        } catch (FileNotFoundException e) {
            PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
            Prepodavatel prepodavatel = tableView.getSelectionModel().getSelectedItem();
            String newPassword = "password";
            prepodavatelRepository.resetPassword(prepodavatel.getId(), newPassword);
        }
    }
}
