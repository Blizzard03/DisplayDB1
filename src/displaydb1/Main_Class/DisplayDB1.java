/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package displaydb1.Main_Class;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Blizzard
 */
public class DisplayDB1 extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/displaydb1/FXML/Main_Menu/FXMLMain_Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Main Menu");
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(final WindowEvent windowEvent) {
                Alert al = new Alert(Alert.AlertType.CONFIRMATION, "Anda yankin untuk keluar program?", ButtonType.OK, ButtonType.CANCEL);
                al.showAndWait();
                if (al.getResult() == ButtonType.CANCEL) {
                    windowEvent.consume();
                }
            }
        }
        );
        stage.setResizable(false);
        stage.setIconified(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
