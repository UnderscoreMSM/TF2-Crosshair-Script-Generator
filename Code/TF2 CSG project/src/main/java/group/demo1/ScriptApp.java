package group.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.*;


public class ScriptApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("appGUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("TF2 Crosshair Script Generator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image("file:appIcon.png"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}