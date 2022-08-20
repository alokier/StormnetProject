package com.strormnet.project.servant.stringConvertors;

import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.servant.Servant;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.util.converter.DoubleStringConverter;

public class StavkaPerHourCustomDoubleStringConverter extends DoubleStringConverter {
    private final DoubleStringConverter converter = new DoubleStringConverter();
    private final TableView tableView;
    private Prepodavatel prepodavatel;

    public StavkaPerHourCustomDoubleStringConverter(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public String toString(Double object) {
        try {
            prepodavatel = (Prepodavatel)tableView.getSelectionModel().getSelectedItem();
            return converter.toString(object);
        } catch (NumberFormatException e) {
            Servant.createAlert("Ошибка!", "Проверьте введённые значения", Alert.AlertType.ERROR);
            return String.valueOf(prepodavatel.getPhoneNumber());
        } catch (RuntimeException b){
            Servant.createAlert("Ошибка!", "Опыт не может быть больше двухзначного числа", Alert.AlertType.ERROR);
            return String.valueOf(prepodavatel.getPhoneNumber());
        }
    }

    @Override
    public Double fromString(String string) {
        try {
            prepodavatel = (Prepodavatel)tableView.getSelectionModel().getSelectedItem();
            if(!string.matches("(\\d{1}|\\d{2})|\\d*[,.]\\d{2}")){
                throw new NumberFormatException();
            }
           if(string.length() > 6){
                throw new RuntimeException();
           }
            return converter.fromString(string);
        } catch (NumberFormatException e) {
            Servant.createAlert("Ошибка!", "Проверьте введённые значения", Alert.AlertType.ERROR);
            return prepodavatel.getStavkaPerHour();
        } catch (RuntimeException b){
            Servant.createAlert("Ошибка!", "Опыт не может быть больше двухзначного числа", Alert.AlertType.ERROR);
            return prepodavatel.getStavkaPerHour();
        }
    }

}
