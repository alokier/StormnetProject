module com.example.stormnetproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stormnetproject to javafx.fxml;
    exports com.example.stormnetproject;
    exports com.example.stormnetproject.Controller;
    opens com.example.stormnetproject.Controller to javafx.fxml;
}