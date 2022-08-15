package com.strormnet.project.servant.nextScene;

import com.strormnet.project.StormnetProject;
import com.strormnet.project.controller.GeneralMenuController;
import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.constant.Constant;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToGeneralMenuControllerFromStart {

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
}
