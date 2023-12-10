/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package displaydb1.Controller.List.AboutMe;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mariq
 */
public class FXML_About_MeController implements Initializable {

    @FXML
    private AnchorPane About;
    @FXML
    private ImageView MyPhoto;
    @FXML
    private ImageView WPALogo;
    @FXML
    private Hyperlink FBlink;
    @FXML
    private Hyperlink Github;
    @FXML
    private Button MainMenuButton;

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void FBlinkclick(ActionEvent event) throws IOException {
          Desktop desktop = Desktop.getDesktop();
        desktop.browse(java.net.URI.create(FBlink.getText()));
    }

    @FXML
    private void GithubClick(ActionEvent event) throws IOException {
          Desktop desktop = Desktop.getDesktop();
        desktop.browse(java.net.URI.create(Github.getText()));
    }

    @FXML
    private void MainMenuButonCllick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/displaydb1/FXML/Main_Menu/FXMLMain_Menu.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Main_Menu");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            About.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

   
    

