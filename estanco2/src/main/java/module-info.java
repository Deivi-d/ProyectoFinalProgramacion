module com.mycompany.estanco2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.mycompany.estanco2 to javafx.fxml;
    exports com.mycompany.estanco2;
}
