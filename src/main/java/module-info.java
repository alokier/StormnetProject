module com.example.stormnetproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.strormnet.project to javafx.fxml;
    exports com.strormnet.project;
    exports com.strormnet.project.Controller;
    opens com.strormnet.project.Controller to javafx.fxml;
}