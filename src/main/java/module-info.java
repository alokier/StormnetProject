module com.strormnet.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.strormnet.project to javafx.fxml;
    exports com.strormnet.project;
    opens com.strormnet.project.controller to javafx.fxml;
    opens com.strormnet.project.enums to javafx.fxml;
    exports com.strormnet.project.enums;

    exports com.strormnet.project.model;
    exports com.strormnet.project.dao;
    exports com.strormnet.project.dao.repository;
    exports com.strormnet.project.model.users;

}