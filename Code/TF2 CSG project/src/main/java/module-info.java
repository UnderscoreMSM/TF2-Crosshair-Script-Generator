module group.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires javafx.base;

    opens group.demo1 to javafx.fxml;
    exports group.demo1;
}