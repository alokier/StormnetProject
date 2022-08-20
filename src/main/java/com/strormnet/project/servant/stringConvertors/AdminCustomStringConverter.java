//package com.strormnet.project.servant.stringConvertors;
//
//import com.strormnet.project.model.users.Prepodavatel;
//import com.strormnet.project.servant.Servant;
//import javafx.scene.control.Alert;
//import javafx.scene.control.TableView;
//import javafx.util.converter.BooleanStringConverter;
//import javafx.util.converter.IntegerStringConverter;
//
//import java.util.Locale;
//
//public class AdminCustomStringConverter extends BooleanStringConverter {
//    private final BooleanStringConverter converter = new BooleanStringConverter();
//    private final TableView tableView;
//    private Prepodavatel prepodavatel;
//
//    public AdminCustomStringConverter(TableView tableView) {
//        this.tableView = tableView;
//    }
//
//    @Override
//    public String toString(Boolean object) {
//        try {
//            prepodavatel = (Prepodavatel)tableView.getSelectionModel().getSelectedItem();
//            if(object.toString().length() > 9){
//                throw new RuntimeException();
//            }
//            return converter.toString(object);
//        } catch (NumberFormatException e) {
//            Servant.createAlert("Ошибка!", "Проверьте введённые значения", Alert.AlertType.ERROR);
//            return String.valueOf(prepodavatel.getAdmin());
//        } catch (RuntimeException b){
//            Servant.createAlert("Ошибка!", "Значение может быть только true или false", Alert.AlertType.ERROR);
//            return String.valueOf(prepodavatel.getAdmin());
//        } catch (Exception e){
//            Servant.createAlert("Ошибка!", "Значение может быть только true или false", Alert.AlertType.ERROR);
//            return String.valueOf(prepodavatel.getAdmin());
//        }
//    }
//
//    @Override
//    public Boolean fromString(String bool) {
//        try {
//            prepodavatel = (Prepodavatel)tableView.getSelectionModel().getSelectedItem();
//            if(!bool.toLowerCase(Locale.ROOT).contains("true")){
//                throw new Exception();
//            }
//            if(!bool.toLowerCase(Locale.ROOT).contains("false")){
//                throw new RuntimeException();
//            }
//            return converter.fromString(bool);
//        } catch (NumberFormatException e) {
//            Servant.createAlert("Ошибка!", "Проверьте введённые значения", Alert.AlertType.ERROR);
//            return prepodavatel.getAdmin();
//        } catch (RuntimeException b){
//            Servant.createAlert("Ошибка!", "Значение может быть только true или false", Alert.AlertType.ERROR);
//            return prepodavatel.getAdmin();
//        } catch (Exception e){
//            Servant.createAlert("Ошибка!", "Значение может быть только true или false", Alert.AlertType.ERROR);
//            return prepodavatel.getAdmin();
//        }
//    }
//}
