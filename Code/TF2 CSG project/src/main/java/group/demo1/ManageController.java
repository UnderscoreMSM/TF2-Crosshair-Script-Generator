package group.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class ManageController {
    File crosshairFolder = new File("crosshairs");
    FilenameFilter filter = ((dir, name) -> name.toLowerCase().endsWith(".vtf")); // Lambda expression for filtering files
    ObservableList<String> list = FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter)));

    @FXML
    private TableView<File[]> tableCrosshair;

    public void initialize() {
        tableCrosshair.getItems().add(crosshairFolder.listFiles(filter));
    }
}
