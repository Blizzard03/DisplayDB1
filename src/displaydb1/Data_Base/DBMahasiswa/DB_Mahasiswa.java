/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package displaydb1.Data_Base.DBMahasiswa;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import displaydb1.Connector.Connector_DB;
import displaydb1.Model.Siswa.Siswa;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Blizzard
 */
public class DB_Mahasiswa {

    private Siswa sws = new Siswa();

    public Siswa getUserModels() {
        return (sws);
    }

    public void setUserModels(Siswa swsa) {
        sws = swsa;
    }

    /*
    * VIEW DATA
     */
    public ObservableList<Siswa> Load() {
        try {
            ObservableList<Siswa> Data_Table = FXCollections.observableArrayList();
            Connector_DB conDB = new Connector_DB();
            conDB.Open_Connection();
            conDB.statement = (Statement) conDB.DisplayDB1.createStatement();
            ResultSet rs = conDB.statement.executeQuery("SELECT * from siswa");
            int z = 1;
            while (rs.next()) {
                Siswa dt = new Siswa();
                dt.setNPM(rs.getString("NPM"));
                dt.setNama(rs.getString("Nama"));
                dt.setAlamat(rs.getString("Alamat"));
                Data_Table.add(dt);
                z++;
            }
            conDB.CloseConnection();
            return Data_Table;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /*
    * VALIDATE DATA
     */
    public int validate(int order) {
        int val = 0;
        try {
            Connector_DB conDB = new Connector_DB();
            conDB.Open_Connection();
            conDB.statement = (Statement) conDB.DisplayDB1.createStatement();
            ResultSet rs = conDB.statement.executeQuery("SELECT COUNT(*) AS SUM FORM siswa WHERE NPM ='" + order + "'");
            while (rs.next()) {
                val = rs.getInt("SUM");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return val;
    }

    /*
    * CREATE DATA
     */
    public boolean Inser_Data() {
        boolean Succes = false;
        Connector_DB conDB = new Connector_DB();
        try {
            conDB.Open_Connection();
            conDB.preparedStatement = conDB.DisplayDB1.clientPrepareStatement("INSERT INTO siswa (NPM,Nama,Alamat) VALUES (?,?,?)");
            conDB.preparedStatement.setString(1, getUserModels().getNPM());
            conDB.preparedStatement.setString(2, getUserModels().getNama());
            conDB.preparedStatement.setString(3, getUserModels().getAlamat());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            conDB.CloseConnection();
            return Succes;
        }
    }

    /*
    * DELETE DATA
     */
    public boolean Delete_Data(String NPM) {
        boolean Success = false;
        Connector_DB con = new Connector_DB();
        try {
            con.Open_Connection();;
            con.preparedStatement = (PreparedStatement) con.DisplayDB1.prepareStatement("DELETE FROM siswa WHERE NPM  = ? ");
            con.preparedStatement.setString(1, NPM);
            con.preparedStatement.executeUpdate();
            Success = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.CloseConnection();
            return Success;
        }
    }

    /*
    * FIND STUNDENT DATA
     */
    public ObservableList<Siswa> findStudent(String NPM, String Nama) {
        try {
            ObservableList<Siswa> Data_Table;
            Data_Table = FXCollections.observableArrayList();
            Connector_DB conDB = new Connector_DB();
            conDB.Open_Connection();
            conDB.statement = (Statement) (java.sql.Statement) conDB.DisplayDB1.createStatement();
            ResultSet rs = (ResultSet) conDB.statement.executeQuery("SELECT * FROM siswa WHERE NPM LIKE '" + NPM + "%' OR Nama LIKE '" + Nama + "%'");
            int z = 1;
            while (rs.next()) {
                Siswa dt = new Siswa();
                dt.setNPM(rs.getString("NPM"));
                dt.setNama(rs.getString("Nama"));
                dt.setAlamat(rs.getString("Alamat"));
                Data_Table.add(dt);
                Data_Table.add(dt);
                z++;
            }
            conDB.CloseConnection();
            return Data_Table;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
