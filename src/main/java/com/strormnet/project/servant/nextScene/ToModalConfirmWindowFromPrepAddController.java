package com.strormnet.project.servant.nextScene;

import com.strormnet.project.StormnetProject;
import com.strormnet.project.controller.GeneralMenuController;
import com.strormnet.project.controller.ModalConfirmationWindowController;
import com.strormnet.project.model.users.User;
import com.strormnet.project.servant.Servant;
import com.strormnet.project.servant.constant.Constant;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Labeled;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ToModalConfirmWindowFromPrepAddController {

    public static<T extends Labeled> void onTheNextSceneWithStage(String resource, String title, Stage currentStage, Integer v, Integer v1, Boolean onModal, T field) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StormnetProject.class.getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(), v, v1);
        scene.getStylesheets().add(StormnetProject.class.getResource(Constant.CSS_MENU).toExternalForm());
        Stage stage2 = new Stage();
        stage2.setTitle(title);
        if(onModal){
            ModalConfirmationWindowController modalConfirmationWindowController = fxmlLoader.getController();
            modalConfirmationWindowController.addOwnerScene(currentStage);
            stage2.initOwner(Servant.getCurrentStage(field));
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setScene(scene);
            stage2.showAndWait();
        }else {
            ModalConfirmationWindowController modalConfirmationWindowController = fxmlLoader.getController();
            modalConfirmationWindowController.addOwnerScene(currentStage);
            stage2.setScene(scene);
            stage2.show();
        }
    }
}
