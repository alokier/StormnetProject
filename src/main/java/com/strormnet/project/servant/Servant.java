package com.strormnet.project.servant;

import com.strormnet.project.StormnetProject;
import com.strormnet.project.controller.AdminPrepodavatelController;
import com.strormnet.project.controller.GeneralMenuController;
import com.strormnet.project.dao.impl.PredmetRepositoryImpl;
import com.strormnet.project.enums.PredmetType;
import com.strormnet.project.model.Predmet;
import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.constant.Constant;
import javafx.application.Application;
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

    public static<T extends User> void writeObject(T user){

    }

    public static void onNextScene(String resource, String title, User user, Integer v, Integer v1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StormnetProject.class.getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(), v, v1);
        scene.getStylesheets().add(StormnetProject.class.getResource(Constant.CSS_APP).toExternalForm());
        Stage stage2 = new Stage();
        stage2.setTitle(title);
        stage2.setScene(scene);
        GeneralMenuController controller = fxmlLoader.getController();
        controller.addData(user);
        stage2.show();
        }

    public static void onAdminPrepScene(String resource, String title, Integer v, Integer v1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StormnetProject.class.getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(), v, v1);
        scene.getStylesheets().add(StormnetProject.class.getResource(Constant.CSS_MENU).toExternalForm());
        Stage stage2 = new Stage();
        stage2.setTitle(title);
        stage2.setScene(scene);
        stage2.show();
    }


        public static <T extends Labeled> void closeScene(T button){
            Stage stage = (Stage) button.getScene().getWindow();
            stage.close();
        }
//    public static void onNextScene(String resource, String title, User user, Integer v, Integer v1) throws IOException {
//            Stage stage = new Stage();
//        FXMLLoader loader = new FXMLLoader(StormnetProject.class.getResource(resource)); //создаем загрузчик
//        Scene scene = stage.setScene(new Scene(loader.load()));
////        Scene scene = new Scene(loader.load(), v, v1);
//        scene.getStylesheets().add(StormnetProject.class.getResource(Constant.CSS_MENU).toExternalForm());
//        stage.setTitle(title);
////        stage.initModality(WINDOW_MODAL);
////        stage.initOwner(((Node)event.getSource()).getScene().getWindow());
//        GeneralMenuController tableController = loader.getController(); //получаем контроллер
//        tableController.addData(user); //передаем данные
//        stage.show();
    }

