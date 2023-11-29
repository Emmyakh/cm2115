package com.example.cm2115;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * The main class representing the entry point of the JavaFX application.
 */
public class Main extends Application {

    /**
     * The overridden method called when the application is launched.
     *
     * @param stage The primary stage representing the top-level container for JavaFX applications.
     */
    @Override
    public void start(Stage stage) {
        try {
            // Load the FXML file defining the graphical layout of the user interface.
            Parent root = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));

            // Create a new Scene with the loaded FXML file as the root.
            Scene scene = new Scene(root);

            // Set the created scene as the content of the primary stage and display the stage.
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            // Handle exceptions that may occur during loading and showing of the JavaFX scene.
            e.printStackTrace();
        }
    }

    /**
     * The main method serving as the entry point for the Java application.
     *
     * @param args Command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        // Launch the JavaFX application, initializing the JavaFX runtime and invoking the start method.
        launch(args);
    }
}
