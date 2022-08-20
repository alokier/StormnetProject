package com.strormnet.project.servant;
import com.strormnet.project.StormnetProject;
import com.strormnet.project.servant.constant.Constant;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Servant{

    public static String generatePassword(Integer amount){
        String result = "";
        String str = "abcdefghijklmnopqrstuvwxyz!@#$%^&*!";
        List<Character> characters = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
        while (result.length() < amount){
            int lowerCase = (int) ((Math.random() * (2) + 2) - 0);
            int random = (int)((Math.random() * (characters.size()) - 1) + 0);
            result = lowerCase >= 3 ? result + characters.get(random).toString().toUpperCase(Locale.ROOT) : result + characters.get(random).toString().toLowerCase(Locale.ROOT);
        }
        return result;
    }

    public static <T extends TextField> void ErrorFieldStyle(Boolean clearFields, T...fields){
        Arrays.stream(fields).forEach(field -> {
            field.setStyle("-fx-border-color:red");
            if(clearFields){
                field.setText("");
            }
        });
    }
    public static <T extends TextField> void ClearErrorFieldStyle(T...fields){
        Arrays.stream(fields).forEach(field -> {
            field.setStyle(null);
        });
    }


    public static<T extends Labeled> void onTheNextSceneWithoutObj(String resource, String title, Integer v, Integer v1, Boolean onModal, T field) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StormnetProject.class.getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(), v, v1);
        scene.getStylesheets().add(StormnetProject.class.getResource(Constant.CSS_MENU).toExternalForm());
        Stage stage2 = new Stage();
        stage2.setTitle(title);
        if(onModal){
            stage2.initOwner(Servant.getCurrentStage(field));
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setScene(scene);
            stage2.showAndWait();
        }else {
            stage2.setScene(scene);
            stage2.show();
        }
    }

    public static <T extends Labeled> Stage getCurrentStage(T field){
        return (Stage) field.getScene().getWindow();
    }

    public static <T extends Labeled> void closeScene(T button){
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public static <T extends Labeled> void toTheAuthorisationScene(String resource, String title, T field) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StormnetProject.class.getResource(resource));
        Scene scene = new Scene(fxmlLoader.load(), 540, 460);
        scene.getStylesheets().add(StormnetProject.class.getResource(Constant.CSS_MENU).toExternalForm());
        Stage stage2 = new Stage();
        stage2.setTitle(title);
        stage2.setScene(scene);
        stage2.show();
        Servant.closeScene(field);
    }

    public static void createAlert(String header, String contentText, Alert.AlertType type){

        Alert alert = new Alert(type);
        alert.setHeaderText(header);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

    public static void writeFile(String url, String username, String password) throws FileNotFoundException {

        try(FileWriter fileWriter = new FileWriter(Constant.DATABASE_PROPERTY_PATH)) {
            fileWriter.write(url + "\n");
            fileWriter.write(username + "\n");
            fileWriter.write(password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeOtherInfo(String path,String...info) throws FileNotFoundException {

        try(FileWriter fileWriter = new FileWriter(path)) {
            Stream.of(info).forEach(gen -> {
                try {
                    fileWriter.write(gen + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readResetToPassword(String path) throws FileNotFoundException {
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get(path))) {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.getProperty("resetToPassword");
    }

   /* public static void onNextScene(String resource, String title, User user, Integer v, Integer v1) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(StormnetProject.class.getResource(resource)); //создаем загрузчик
        stage.setScene(new Scene(loader.load()));
        stage.setTitle(title);
        stage.initModality(WINDOW_MODAL);
//        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        GeneralMenuController tableController = loader.getController(); //получаем контроллер
        tableController.addData(user); //передаем данные
        stage.show(); }*/

}

