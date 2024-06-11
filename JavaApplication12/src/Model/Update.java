/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author sanam
 */
public class Update {
    public static boolean update(int id, String bookName, String bookEdition, String bookPage, String bookPrice, String bookPublisher, String selectedOption) {
        Connection conn = null;
        PreparedStatement pst = null;

        try {
            conn = DBConn.connect();

            String query = "UPDATE books SET name=?, edition=?, pages=?, price=?, publisher=?, selected=? WHERE id=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, bookName);
            pst.setString(2, bookEdition);
            pst.setString(3, bookPage);
            pst.setString(4, bookPrice);
            pst.setString(5, bookPublisher);
            pst.setString(6, selectedOption);
            pst.setInt(7, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            // System.out.println(e);
            System.out.println("hi");
            return false;
        }
    }

    public static boolean checkin(int id, String returndate) {
        Connection conn;
        PreparedStatement pst;

        try {
            conn = DBConn.connect();

            String query = "UPDATE book_loans SET rutern_date =? WHERE id=?";

            pst = conn.prepareStatement(query);
            pst.setString(1, returndate);
            pst.setInt(2, id);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

    
}
