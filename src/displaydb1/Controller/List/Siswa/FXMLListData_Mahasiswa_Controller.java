/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package displaydb1.Controller.List.Siswa;

import displaydb1.Model.Siswa.Siswa;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import displaydb1.Controller.Main_Menu.FXMLMAIN_MenuController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Blizzard
 */
public class FXMLListData_Mahasiswa_Controller {

    @FXML
    private TableView<Siswa> TableViewMahasiswa;
    @FXML
    private Button UpdateButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button MainMenuButtoon;
    @FXML
    private Button Add_DataMhs;
    @FXML
    private Button FirstButton;
    @FXML
    private Button BeforeButon;
    @FXML
    private Button AfterButon;
    @FXML
    private Button LastButon;
    @FXML
    private TextField DataMahaSiswaSearch;

    private int Val = 0;
    private String NPM = "";

    /**
     * Initializes the controller class.
     */
    //@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        DataShow();
    }

    //Table Data Siswa
    public void DataShow() {
        ObservableList<Siswa> data = FXMLMAIN_MenuController.dataBaseMahasiswa.Load();
        if (data != null) {
            TableViewMahasiswa.getColumns().clear();
            TableViewMahasiswa.getItems().clear();
            TableColumn col = new TableColumn("NPM");
            col.setCellFactory(new PropertyValueFactory<Siswa, String>("NPM"));
            TableViewMahasiswa.getColumns().addAll(col);
            col.setCellFactory(new PropertyValueFactory<Siswa, String>("Nama"));
            TableViewMahasiswa.getColumns().addAll(col);
            col.setCellFactory(new PropertyValueFactory<Siswa, String>("Alamat"));
            TableViewMahasiswa.getColumns().addAll(col);
            TableViewMahasiswa.setItems(data);
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
            a.showAndWait();
            TableViewMahasiswa.getScene().getWindow().hide();;
        }

    }

    @FXML
    private void UpdateButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/displaydb1/FXML/Form/Mahasiwa/FXMLFormMahasiswa.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Ubah Mahasiswa");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            Add_DataMhs.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void DeleteButtonClick(ActionEvent event) {
        Siswa sws = new Siswa();
        sws = TableViewMahasiswa.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure will be delete this data is permanent deleted?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            if (FXMLMAIN_MenuController.dataBaseMahasiswa.Delete_Data(sws.getNPM()));
            Alert b = new Alert(Alert.AlertType.INFORMATION, "Data have been Deleted", ButtonType.OK);
            b.showAndWait();
        } else {
            Alert b = new Alert(Alert.AlertType.ERROR, "Data Fail to Delete", ButtonType.OK);
            b.showAndWait();
        }
        DataShow();
        FirstButtonClick(event);
    }

    @FXML
    private void MainMenuButtonClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/displaydb1/FXML/Main_Menu/FXMLMain_Menu.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Main Menu");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            MainMenuButtoon.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void Add_DataMhsClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/displaydb1/FXML/Form/Mahasiwa/FXMLFormMahasiswa.fxml"));
            Parent root = (Parent) loader.load();
            Scene scene = new Scene(root);
            Stage stg = new Stage();
            stg.setTitle("Tambah Mahasiswa");
            stg.initModality(Modality.APPLICATION_MODAL);
            stg.setResizable(false);
            stg.setIconified(false);
            stg.setScene(scene);
            stg.show();
            Add_DataMhs.getScene().getWindow().hide();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    @FXML
    private void FirstButtonClick(ActionEvent event) {
        TableViewMahasiswa.getSelectionModel().selectFirst();
        TableViewMahasiswa.requestFocus();
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
        TableViewMahasiswa.getSelectionModel().selectAboveCell();
        TableViewMahasiswa.requestFocus();
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {
        TableViewMahasiswa.getSelectionModel().selectBelowCell();
        TableViewMahasiswa.requestFocus();
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
        TableViewMahasiswa.getSelectionModel().selectLast();
        TableViewMahasiswa.requestFocus();
    }

    @FXML
    private void DataMahaSiswaFinder(KeyEvent event) {
        Siswa sws = new Siswa();
        String key = DataMahaSiswaSearch.getText();
        if (key != "") {
            ObservableList<Siswa> data = FXMLMAIN_MenuController.dataBaseMahasiswa.Load();
            if (data != null) {
                TableViewMahasiswa.getColumns().clear();
                TableViewMahasiswa.getItems().clear();
                TableColumn col = new TableColumn("NPM");
                col.setCellFactory(new PropertyValueFactory<Siswa, String>("NPM"));
                TableViewMahasiswa.getColumns().addAll(col);
                col.setCellFactory(new PropertyValueFactory<Siswa, String>("Nama"));
                TableViewMahasiswa.getColumns().addAll(col);
                col.setCellFactory(new PropertyValueFactory<Siswa, String>("Alamat"));
                TableViewMahasiswa.getColumns().addAll(col);
                TableViewMahasiswa.setItems(data);
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR, "404 Data Not Found!", ButtonType.OK);
                a.showAndWait();
                TableViewMahasiswa.getScene().getWindow().hide();;
            }
        } else {
            DataShow();
        }
    }

}
