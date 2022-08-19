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

    public UpdateDemonThread(TableView<Prepodavatel> tableView) {
        this.tableView = tableView;
        setDaemon(true);
    }

    @Override
    public void run() {
        PrepodavatelRepositoryImpl prepodavatelRepository = new PrepodavatelRepositoryImpl();
        oldValueFromTheTable = prepodavatelRepository.getPrepodavatelsCount();
        Stage stage = (Stage) tableView.getScene().getWindow();
        while(stage.isShowing()) {
            newValue = prepodavatelRepository.getPrepodavatelsCount();
            System.out.println(newValue);
            if(newValue != oldValueFromTheTable){
                List<Prepodavatel> all = prepodavatelRepository.getAll();
                tableView.getItems().clear();
                tableView.getItems().addAll(all);
                oldValueFromTheTable = newValue;
            }
        }

    }
}

