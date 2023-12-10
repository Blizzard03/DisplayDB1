/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package displaydb1.Controller.Form.Mahasiswa;

import displaydb1.Model.Siswa.Siswa;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Blizzard
 */
public class FXMLFormMahasiswaController implements Initializable {

    public boolean TextEdit;
    @FXML
    private TextField txtNPM;
    @FXML
    private TextField Txt_Nama;
    @FXML
    private TextArea Txt_Alamat;
    @FXML
    private Button Submit_btn;
    @FXML
    private Button Reset_Btn;
    @FXML
    private Button cancelbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void execute(Siswa sws) {
        if (!sws.getNPM().isEmpty()) {
            TextEdit = true;
            txtNPM.setText(sws.getNPM());
            Txt_Nama.setText(sws.getNama());
            Txt_Alamat.setText(sws.getAlamat());
            Txt_Nama.requestFocus();
            txtNPM.setEditable(false);
        }

    }

    @FXML
    private void Submit_Click(ActionEvent event) {
    }

    @FXML
    private void Reset_Click(ActionEvent event) {
        Alert art = new Alert(Alert.AlertType.WARNING, "The data will be permanently deleted and it will be impossible to restore it. There will be no available actions to reverse this process!!", ButtonType.YES,
                ButtonType.NO);
        art.showAndWait();
        if (art.getResult() == ButtonType.YES) {
            
        }
    }

    @FXML
    private void CancelClick(ActionEvent event) {
          Alert art = new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure Want Cancel This Process Now?", ButtonType.YES,
                ButtonType.NO);
        art.showAndWait();
        if (art.getResult() == ButtonType.YES) {
            cancelbtn.getScene().getWindow().hide();
        }
    }

}
