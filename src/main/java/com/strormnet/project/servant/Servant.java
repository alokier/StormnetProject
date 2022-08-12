package com.strormnet.project.servant;

import javafx.scene.control.TextField;

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
    }

