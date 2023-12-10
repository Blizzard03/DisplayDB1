/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package displaydb1.Data_Base.DBMataKuliah;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import displaydb1.Connector.Connector_DB;
import displaydb1.Model.Matakuliah.MataKuliah;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Blizzard
 */
public class DB_MataKuliah {

    private MataKuliah mth = new MataKuliah();

    public MataKuliah getUserModels() {
        return (mth);
    }

    public void setUserModels(MataKuliah mths) {
        mth = mths;
    }

    /*
    * VIEW DATA
     */
    public ObservableList<MataKuliah> Load() {
        try {
            ObservableList<MataKuliah> Data_Table = FXCollections.observableArrayList();
            Connector_DB conDB = new Connector_DB();
            conDB.Open_Connection();
            conDB.statement = (Statement) conDB.DisplayDB1.createStatement();
            ResultSet rs = conDB.statement.executeQuery("SELECT * FROM matakuliah ");
            int z = 1;
            while (rs.next()) {
                MataKuliah dt = new MataKuliah();
                dt.setKodeMataKuliah(rs.getString("KodeMK"));
                dt.setNamaMataKuliah(rs.getString("NamaMK"));
                dt.setSKS(rs.getInt("SKS"));
                dt.setPraktek(rs.getInt("Praktek"));
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
            conDB.preparedStatement = conDB.DisplayDB1.clientPrepareStatement("INSERT INTO matakuliah (KodeMK,NamaMK,SKS,Praktek) VALUES (?,?,?,?)");
            conDB.preparedStatement.setString(1, getUserModels().getKodeMataKuliah());
            conDB.preparedStatement.setString(2, getUserModels().getKodeMataKuliah());
            conDB.preparedStatement.setInt(3, getUserModels().getSKS());
            conDB.preparedStatement.setInt(4, getUserModels().getPraktek());
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
    public boolean Delete_Data(String KodeMK) {
        boolean Success = false;
        Connector_DB con = new Connector_DB();
        try {
            con.Open_Connection();;
            con.preparedStatement = (PreparedStatement) con.DisplayDB1.prepareStatement("DELETE FROM matakuliah WHERE KodeMK  = ? ");
            con.preparedStatement.setString(1, KodeMK);
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
    * FIND MATERIAL DATA
     */
    public ObservableList<MataKuliah> findStudent(String KodeMK, String Matakuliah) {
        try {
            ObservableList<MataKuliah> Data_Table;
            Data_Table = FXCollections.observableArrayList();
            Connector_DB conDB = new Connector_DB();
            conDB.Open_Connection();
            conDB.statement = (Statement) (java.sql.Statement) conDB.DisplayDB1.createStatement();
            ResultSet rs = (ResultSet) conDB.statement.executeQuery("SELECT * FROM matakuliah WHERE KodeMK LIKE '" + KodeMK + "%' OR NamaMK LIKE '" + Matakuliah + "%'");
            int z = 1;
            while (rs.next()) {
                MataKuliah dt = new MataKuliah();
                dt.setKodeMataKuliah(rs.getString("KodeMK"));
                dt.setNamaMataKuliah(rs.getString("NamaMK"));
                dt.setSKS(rs.getInt("SKS"));
                dt.setPraktek(rs.getInt("Praktek"));
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
