package com.strormnet.project.servant.stringConvertors;

import com.strormnet.project.model.users.Prepodavatel;
import com.strormnet.project.servant.Servant;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.util.converter.IntegerStringConverter;


public class PhoneNumberCustomIntegerStringConverter extends IntegerStringConverter {

    private final IntegerStringConverter converter = new IntegerStringConverter();
    private final TableView tableView;
    private Prepodavatel prepodavatel;

    public PhoneNumberCustomIntegerStringConverter(TableView tableView) {
        this.tableView = tableView;
    }

    @Override
    public String toString(Integer object) {
        try {
            prepodavatel = (Prepodavatel)tableView.getSelectionModel().getSelectedItem();
            if(object.toString().length() > 9){
                throw new RuntimeException();
            }
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
    public Integer fromString(String string) {
        try {
            prepodavatel = (Prepodavatel)tableView.getSelectionModel().getSelectedItem();
            if(!string.matches("\\d{9}")){
                throw new NumberFormatException();
            }
            if(string.length() > 9){
                throw new RuntimeException();
            }
            return converter.fromString(string);
        } catch (NumberFormatException e) {
            Servant.createAlert("Ошибка!", "Проверьте введённые значения", Alert.AlertType.ERROR);
            return prepodavatel.getPhoneNumber();
        } catch (RuntimeException b){
            Servant.createAlert("Ошибка!", "Опыт не может быть больше двухзначного числа", Alert.AlertType.ERROR);
            return prepodavatel.getPhoneNumber();
        }
    }

}

