module com.example.exerciciodepoo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.exerciciodepoo to javafx.fxml;
    exports com.example.exerciciodepoo;
}