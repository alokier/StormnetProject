package com.strormnet.project.servant;

import com.strormnet.project.Application;
import com.strormnet.project.controller.GeneralMenuController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
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

        public static void onNextScene(String getResource, String setTitle, GeneralMenuController controller, Integer v, Integer v1) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(getResource));
            Scene scene = new Scene(fxmlLoader.load(), v, v1);
            Stage stage2 = new Stage();
            controller = (GeneralMenuController) fxmlLoader.getController();
            stage2.setTitle(setTitle);
            stage2.setScene(scene);
            stage2.show();
        }
    }

