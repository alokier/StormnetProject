package com.strormnet.project.servant.updateThreads;

import com.strormnet.project.dao.impl.PrepodavatelRepositoryImpl;
import com.strormnet.project.model.users.Prepodavatel;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.util.List;

public class UpdateDemonThread extends Thread {

    private Integer newValue;
    private Integer oldValueFromTheTable;
    private TableView<Prepodavatel> tableView;
    private Boolean resetPassword = false;

    public UpdateDemonThread(TableView<Prepodavatel> tableView) {
        this.tableView = tableView;
        setDaemon(true);
    }

    public UpdateDemonThread() {
        setDaemon(true);
    }

    @Override
    public void run() {
        PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
        oldValueFromTheTable = prepodavatelRepository.getPrepodavatelsCount();
        Stage stage = (Stage) tableView.getScene().getWindow();
        try {
            sleep(150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(stage.isShowing()) {
            newValue = prepodavatelRepository.getPrepodavatelsCount();
            System.out.println(newValue);
            if(newValue != oldValueFromTheTable){
                updateTable(tableView);
                oldValueFromTheTable = newValue;
            }
            if(resetPassword){
                updateTable(tableView);
                setResetPassword(false);
            }
        }

    }

    public Boolean getResetPassword() {
        return resetPassword;
    }

    public void setResetPassword(Boolean resetPassword) {
        this.resetPassword = resetPassword;
    }

    public TableView<Prepodavatel> getTableView() {
        return tableView;
    }

    public void setTableView(TableView<Prepodavatel> tableView) {
        this.tableView = tableView;
    }

    private static void updateTable(TableView tableView){
        PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
        List<Prepodavatel> all = prepodavatelRepository.getAll();
        tableView.getItems().clear();
        tableView.getItems().addAll(all);
    }
}

