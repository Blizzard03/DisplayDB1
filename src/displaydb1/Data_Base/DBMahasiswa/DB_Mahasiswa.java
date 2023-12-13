/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package displaydb1.Data_Base.DBMahasiswa;

import displaydb1.Connector.Connector_DB;
import displaydb1.Model.Siswa.Siswa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Blizzard
 */
public class DB_Mahasiswa {

    private Siswa sws = new Siswa();

    public Siswa getSiswaModels() {
        return (sws);
    }

    public void setSiswaModels(Siswa swsa) {
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
            conDB.statement = conDB.DisplayDB1.createStatement();
            ResultSet rs = conDB.statement.executeQuery("select * from siswa");
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
    public int validate(String order) {
        int val = 0;
        try {
            Connector_DB conDB = new Connector_DB();
            conDB.Open_Connection();
            conDB.statement = (Statement) conDB.DisplayDB1.createStatement();
            ResultSet rs = conDB.statement.executeQuery("select count(*) as sum from siswa where NPM ='" + order + "'");
            while (rs.next()) {
                val = rs.getInt("sum");
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        return val;
    }

    /*
    * CREATE DATA
     */
    public boolean Insert_Data() {
        boolean Succes = false;
        Connector_DB conDB = new Connector_DB();
        try {
            conDB.Open_Connection();
            conDB.preparedStatement = conDB.DisplayDB1.prepareStatement("insert into siswa (NPM,Nama,Alamat) values (?,?,?)");
            conDB.preparedStatement.setString(1, getSiswaModels().getNPM());
            conDB.preparedStatement.setString(2, getSiswaModels().getNama());
            conDB.preparedStatement.setString(3, getSiswaModels().getAlamat());
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
            con.preparedStatement = con.DisplayDB1.prepareStatement("DELETE FROM siswa WHERE NPM  = ? ");
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
            conDB.statement = conDB.DisplayDB1.createStatement();
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

    /*
    * Update Data
     */
    public boolean Update_Data() {
        boolean Success = false;
        Connector_DB cndb = new Connector_DB();
        try {
            cndb.Open_Connection();
            cndb.preparedStatement = cndb.DisplayDB1.prepareStatement("UPDATE siswa set Nama=?, Alamat=? WHERE NPM=?");
            cndb.preparedStatement.setString(1, getSiswaModels().getNama());
            cndb.preparedStatement.setString(2, getSiswaModels().getAlamat());
            cndb.preparedStatement.setString(3, getSiswaModels().getNPM());
            cndb.preparedStatement.executeUpdate();
            Success = true;
        } catch (Exception e) {
            e.printStackTrace();
            Success = false;
        } finally {
            cndb.CloseConnection();
            return Success;
        }
    }

}
