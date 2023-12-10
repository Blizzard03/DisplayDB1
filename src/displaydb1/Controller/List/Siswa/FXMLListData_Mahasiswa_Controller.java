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

    
    //Table Data Siswa
    public void DataShow(String aa, String BB){
        //ObservableList<Siswa> data 
    }
    @FXML
    private void UpdateButtonClick(ActionEvent event) {
    }

    @FXML
    private void DeleteButtonClick(ActionEvent event) {
    }

    @FXML
    private void MainMenuButtonClick(ActionEvent event) {
    }

    @FXML
    private void Add_DataMhsClick(ActionEvent event) {
    }

    @FXML
    private void FirstButtonClick(ActionEvent event) {
    }

    @FXML
    private void BeforeButonClick(ActionEvent event) {
    }

    @FXML
    private void AfterButonClick(ActionEvent event) {
    }

    @FXML
    private void LastButtonClick(ActionEvent event) {
    }

    @FXML
    private void DataMahaSiswaFinder(KeyEvent event) {
    }

}
