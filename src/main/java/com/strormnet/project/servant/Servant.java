package com.strormnet.project.servant;

import com.strormnet.project.StormnetProject;
import com.strormnet.project.controller.GeneralMenuController;
import com.strormnet.project.model.users.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class Servant {

    public static <T extends TextField> void ErrorFieldStyle(Boolean clearFields, T...fields){
        Arrays.stream(fields).forEach(field -> {
            field.setStyle("-fx-border-color:red");
            if(clearFields){
                field.setText("");
            }
        });
        }

    public static void onNextScene(String resource, String title, User user, Integer v, Integer v1) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(StormnetProject.class.getResource(resource)); //создаем загрузчик
        stage.setScene(new Scene(loader.load()));
        stage.setTitle(title);
//        stage.initModality(WINDOW_MODAL);
//        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
        GeneralMenuController tableController = loader.getController(); //получаем контроллер
        tableController.addData(user); //передаем данные
        stage.show();
        }

        public static <T extends Labeled> void closeScene(T button){
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        }
    }

