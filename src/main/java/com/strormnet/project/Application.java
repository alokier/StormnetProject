package com.strormnet.project;

import com.strormnet.project.dao.impl.PredmetRepositoryImpl;
import com.strormnet.project.enums.PredmetType;
import com.strormnet.project.model.Predmet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com.stormnet.resources/Pass.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 540, 460);
        stage.setTitle("Авторизация");
        stage.setScene(scene);
        stage.show();
        Predmet predmet = new Predmet("TBD", PredmetType.QA);
        PredmetRepositoryImpl predmetRepository = new PredmetRepositoryImpl();
        predmetRepository.updateById(2, predmet);
    }

    public static void main(String[] args) throws InterruptedException {

        launch();
    }
}