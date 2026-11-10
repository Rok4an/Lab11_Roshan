module org.roshan.lab11_roshan {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.roshan.lab11_roshan to javafx.fxml;
    exports org.roshan.lab11_roshan;
}