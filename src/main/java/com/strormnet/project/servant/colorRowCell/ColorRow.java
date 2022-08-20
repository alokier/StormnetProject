//package com.strormnet.project.servant.colorRowCell;
//
//import com.strormnet.project.model.users.Prepodavatel;
//import javafx.scene.control.TableRow;
//import javafx.scene.control.TableView;
//
//public class ColorRow extends TableRow<Prepodavatel> {
//
//    private TableView tableView;
//
//    public ColorRow(TableView tableView) {
//        this.tableView = tableView;
//    }
//
//    @Override
//    protected void updateItem(Prepodavatel vars, boolean b) {
//        super.updateItem((Prepodavatel)tableView.getSelectionModel().getSelectedItem(), b);
//        boolean flag = true; // тут условие, по которому стоит разукрашитьвать строку или нет.
//        if (flag) {
//            this.getStyleClass().add("-fx-background-color:yellow;");
//        } else {
//            this.getStyleClass().add("-fx-background-color:yellow;");
//        }
//    }
//}
