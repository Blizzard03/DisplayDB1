/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package displaydb1.Connector;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;

/**
 *
 * @author Blizzard
 */
public class Connector_DB {

    public Connection DisplayDB1;
    public Statement statement;
    public PreparedStatement preparedStatement;

    public Connector_DB() {
        this.DisplayDB1 = null;
    }

    public void Open_Connection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DisplayDB1 = (Connection) DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/siswa_2020130036?user=Blizzard_Wolf_Smith&password=Bl1zz4rd03");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CloseConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (DisplayDB1 != null) {
                DisplayDB1.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
