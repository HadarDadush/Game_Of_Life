// Main class that launches the Game of Life application and sets up the JavaFX window.

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameOfLife extends Application { 

    // Start the application
    public void start(Stage stage) throws Exception { 
        Parent root = (Parent) FXMLLoader.load(getClass().getResource("GameOfLife.fxml")); 
        Scene scene = new Scene(root); 
        stage.setTitle("GameOfLife"); 
        stage.setScene(scene); 
        stage.show(); 
    } 

    // Main method to launch the application
    public static void main(String[] args) { 
        launch(args); 
    } 
}
