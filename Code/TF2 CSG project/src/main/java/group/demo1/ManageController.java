package group.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

// TODO: refresh choiceboxes after deleting a crosshair
public class ManageController {
    File crosshairFolder = new File("crosshairs");
    FilenameFilter filter = ((dir, name) -> name.toLowerCase().endsWith(".vtf")); // Lambda expression for filtering files
    ObservableList<String> list = FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter)));

    @FXML
    private ListView<String> lvCrosshairs = new ListView<>();

    public void initialize() {
        lvCrosshairs.getItems().addAll(list);
    }

    @FXML
    protected void onDeleteClick() { // TODO Delete both files
        String fileName = lvCrosshairs.getSelectionModel().getSelectedItem();
        // Deleting both VTF and VMT files
        if ( new File("crosshairs/" + fileName).delete() &&  new File("crosshairs/" + removeExtension(fileName) + ".vmt").delete()) {
            System.out.println(fileName + " has been deleted.");
        } else {
            System.out.println("Deletion failed for " + fileName);
        }
        lvCrosshairs.getItems().clear();
        lvCrosshairs.getItems().addAll(FXCollections.observableList(Arrays.asList(crosshairFolder.list(filter))));
    }

    public String removeExtension(String fileName) {
        if (fileName.contains(".")) {
            return fileName.substring(0, fileName.lastIndexOf("."));
        } else {
            return null;
        }
    }
}
