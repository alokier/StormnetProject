package com.strormnet.project;

import com.strormnet.project.dao.impl.PredmetRepositoryImpl;
import com.strormnet.project.enums.PredmetType;
import com.strormnet.project.model.Predmet;
import com.strormnet.project.servant.Validation.Threads.CheckAdminsThread;
import com.strormnet.project.servant.Validation.Threads.TakeFromDataBaseThread;
import com.strormnet.project.servant.Validation.Validation;
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
        Validation validation = new Validation(123,"admin");
        CheckAdminsThread checkAdminsThread = new CheckAdminsThread(validation);
        TakeFromDataBaseThread takeFromDataBaseThread = new TakeFromDataBaseThread(validation);
        checkAdminsThread.start();
        takeFromDataBaseThread.start();
        checkAdminsThread.join();
        takeFromDataBaseThread.join();
        System.out.println(validation.test());
        System.out.println(validation.getAdmins());
        System.out.println(validation.getPrepodavatels());
        launch();
        //TODO перевесить логику на кнопку и проверить как она работает

    }
}