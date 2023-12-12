/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package displaydb1.Controller.Main_Menu;

//Master Database Import
import displaydb1.Data_Base.DBMahasiswa.DB_Mahasiswa;
import displaydb1.Data_Base.DBMataKuliah.DB_MataKuliah;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Blizzard
 */
public class FXMLMAIN_MenuController {

    //Data Base Mahasiswa
    public static DB_Mahasiswa dataBaseMahasiswa = new DB_Mahasiswa();
    
    //Data Base Mata Kuliah
    public static DB_MataKuliah dataBaseMatakuliah = new DB_MataKuliah();
    
    @FXML
    private MenuItem Data_Mahasiswa;
    @FXML
    private MenuItem Data_Mata_Kuliah;
    @FXML
    private MenuItem About_Menu;
    @FXML
    private AnchorPane Main_Menu;
    @FXML
    private MenuItem Form_Mahasiswa;
    @FXML
    private MenuItem Form_MataKuliah;

    @FXML
    private void Mahasiswa_Table_View(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/displaydb1/FXML/List_Siswa/FXMLListData_Siswa.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Tabel Data Mahasiswa");
            stg.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(final WindowEvent windowEvent) {
                    Alert al = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Want Quit The Program?", ButtonType.OK, ButtonType.CANCEL);
                    al.showAndWait();
                    if (al.getResult() == ButtonType.CANCEL) {
                        windowEvent.consume();
                    }
                }
            }
            );
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            Main_Menu.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Mata_Kuliah_Table_View(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/displaydb1/FXML/List_MataKuliah/FXMLListData_MataKuliah.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Tabel Data Mata Kuliah");
            stg.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(final WindowEvent windowEvent) {
                    Alert al = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Want Quit The Program?", ButtonType.OK, ButtonType.CANCEL);
                    al.showAndWait();
                    if (al.getResult() == ButtonType.CANCEL) {
                        windowEvent.consume();
                    }
                }
            }
            );
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            Main_Menu.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void AboutMenuClick(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/displaydb1/FXML/About/FXML_About_Me.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("About Me");
            stg.setOnCloseRequest(new EventHandler<WindowEvent>() {
                public void handle(final WindowEvent windowEvent) {
                    Alert al = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Want Quit The Program?", ButtonType.OK, ButtonType.CANCEL);
                    al.showAndWait();
                    if (al.getResult() == ButtonType.CANCEL) {
                        windowEvent.consume();
                    }
                }
            }
            );
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            Main_Menu.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Form_Mahasiswa_Click(ActionEvent event) {
    }

    @FXML
    private void Form_MataKuliah_Click(ActionEvent event) {
    }
    
    
}
