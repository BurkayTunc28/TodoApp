module org.example.todoapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens org.example.todoapp to javafx.fxml;
    exports org.example.todoapp;
}