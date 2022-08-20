package com.strormnet.project;

import com.strormnet.project.dao.ConnectDao;
import com.strormnet.project.dao.impl.PredmetRepositoryImpl;
import com.strormnet.project.enums.PredmetType;
import com.strormnet.project.model.Predmet;
import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.constant.Constant;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class StormnetProject extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StormnetProject.class.getResource(Constant.AUTHORISATION_PATH));
        Scene scene = new Scene(fxmlLoader.load(), 540, 460);
        scene.getStylesheets().add(getClass().getResource(Constant.CSS_APP).toExternalForm());
        stage.setTitle("Авторизация");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        launch();
    }
}