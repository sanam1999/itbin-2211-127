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
public class Read {
     public static boolean chackUser(String email, String password) {
        Connection conn = DBConn.connect();
        PreparedStatement pst;
        ResultSet rs;
        String query = "SELECT email, password FROM user WHERE email = ? AND password = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();

            if (rs.next()) {
                System.out.println("1");
                return true;

            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public static int getid(String tablename) {

        System.out.println(tablename);

        Connection conn = DBConn.connect();
        String q = "SELECT  id FROM " + tablename + " ORDER BY  id DESC LIMIT 1";
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement(q);
            rs = pst.executeQuery();

            if (rs.next()) {
                return rs.getInt("id") + 1;
            }
            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 1;
        }
    }

    public static ResultSet chekIn(int chekeinid) {
        System.out.println(chekeinid);
        PreparedStatement pst;
        ResultSet rs = null;
        Connection conn = DBConn.connect();

        String query = "SELECT book_id, member_Name FROM book_loans WHERE id = ?";

        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, chekeinid); 
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }
    }

    public static ResultSet loadTable(String tablename) {
        PreparedStatement pst;
        ResultSet rs = null;
        Connection conn = DBConn.connect();


        String query = "SELECT * FROM `" + tablename + "`";

        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e);
            return rs;
        }
    }

    public static ResultSet getname() {
        PreparedStatement pst;
        ResultSet rs = null;
        Connection conn = DBConn.connect();


        String query = "SELECT first_name FROM employee ";

        try {
            pst = conn.prepareStatement(query);
            rs = pst.executeQuery();

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return rs;
        }
    }

    
}
