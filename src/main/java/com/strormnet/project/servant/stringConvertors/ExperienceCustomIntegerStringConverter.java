package com.strormnet.project.servant.stringConvertors;

import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.servant.Servant;
import javafx.scene.control.*;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.List;

public class ExperienceCustomIntegerStringConverter extends IntegerStringConverter {

    private final IntegerStringConverter converter = new IntegerStringConverter();
    private final TableView tableView;
    private Prepodavatel prepodavatel;

    public ExperienceCustomIntegerStringConverter(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public String toString(Integer object) {
        try {
            prepodavatel = (Prepodavatel)tableView.getSelectionModel().getSelectedItem();
            if(object.toString().length() > 2){
                throw new RuntimeException();
            }
            return converter.toString(object);
        } catch (NumberFormatException e) {
            Servant.createAlert("Ошибка!", "Проверьте введённые значения", Alert.AlertType.ERROR);
            return String.valueOf(prepodavatel.getExperience());
        } catch (RuntimeException b){
            Servant.createAlert("Ошибка!", "Опыт не может быть больше двухзначного числа", Alert.AlertType.ERROR);
            return String.valueOf(prepodavatel.getExperience());
        }
    }

    @Override
    public Integer fromString(String string) {
        try {
            prepodavatel = (Prepodavatel)tableView.getSelectionModel().getSelectedItem();
            if(!string.matches("\\d{2}|\\d")){
                throw new NumberFormatException();
            }
            if(string.length() > 2){
                throw new RuntimeException();
            }
            return converter.fromString(string);
        } catch (NumberFormatException e) {
            Servant.createAlert("Ошибка!", "Проверьте введённые значения", Alert.AlertType.ERROR);
            return prepodavatel.getExperience();
        } catch (RuntimeException b){
            Servant.createAlert("Ошибка!", "Опыт не может быть больше двухзначного числа", Alert.AlertType.ERROR);
            return prepodavatel.getExperience();
        }
    }

}
