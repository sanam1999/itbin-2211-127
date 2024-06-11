/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author sanam
 */
public class Delete {
    

    public static boolean delete(int id, String table) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = DBConn.connect();
            String query = "delete from " + table + " where id = ?";
            pst = conn.prepareStatement(query);
            pst.setInt(1, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("hi");
            return false;
        }
    }
}
