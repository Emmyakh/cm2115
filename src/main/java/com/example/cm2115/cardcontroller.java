package com.example.cm2115;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The cardcontroller class handles user interactions for card-related actions.
 * It provides methods for navigating back to the Account Manager view.
 */
public class cardcontroller {
    
    private Stage stage;  // JavaFX stage for managing scenes
    private Scene scene;  // JavaFX scene for displaying UI
    private Parent root;  // Parent node for the scene

    /**
     * Navigates back to the Account Manager view when the "Back" button is clicked.
     *
     * @param event ActionEvent triggered by the button click.
     * @throws IOException If an I/O error occurs during the navigation process.
     */
    public void backtoadmin(ActionEvent event) throws IOException {
        // Load the Account Manager view
        root = FXMLLoader.load(getClass().getResource("AccountManager.fxml"));
        
        // Get the stage and scene from the event source
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        // Set the scene to the loaded FXML file
        stage.setScene(scene);
        stage.show();
    }
}
