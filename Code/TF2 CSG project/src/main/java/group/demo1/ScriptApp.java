package group.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

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

    public static void main(String[] args) throws IOException {
        byte[] byteArray = Files.readAllBytes(Paths.get("C:\\Users\\Mohammed\\Desktop\\_CryLink.vtf"));
//        byte[] byteArray = Files.readAllBytes(Paths.get("C:\\Users\\Mohammed\\Desktop\\brackets.vtf"));
//        InputStream balls = new FileInputStream("C:\\Users\\Mohammed\\Desktop\\_CryLink.vtf");
//        DataInputStream poop = new DataInputStream(balls);
//        System.out.println(poop);
        System.out.println(Arrays.toString(byteArray));
//        int b = (byteArray[16]);
//        System.out.println(byteArray[16]);
//        System.out.println(byteArray[18]);
        launch();
    }
}