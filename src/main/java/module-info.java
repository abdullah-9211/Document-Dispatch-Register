module com.example.cheez.documentdispatch {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cheez.documentdispatch to javafx.fxml;
    exports com.example.cheez.documentdispatch;
}