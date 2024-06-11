package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sanam
 */
public class Create {



    public static boolean CreateAcc(String name, String email, String password) {
        Connection conn = DBConn.connect();
        PreparedStatement pst;
        String query = "INSERT INTO user (name, email, password) VALUES (?, ?, ?)";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, password);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;

        }
    }


    public static boolean addDB(String bookName, String bookEdition, String bookPage, String bookPrice, String bookPublisher, String selectedOption) {
        Connection conn = DBConn.connect();
        PreparedStatement pst;
        String query = "INSERT INTO books (name, edition, pages, price, publisher, selected) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, bookName);
            pst.setString(2, bookEdition);
            pst.setString(3, bookPage);
            pst.setString(4, bookPrice);
            pst.setString(5, bookPublisher);
            pst.setString(6, selectedOption);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }

   




    public static boolean addEpm(String fname, String lname, int phone, String email, int salary) {
        Connection conn = DBConn.connect();
        PreparedStatement pst;
        String query = "INSERT INTO employee (first_name, last_name, phone_number,email, salary) VALUES (?, ?,?, ?, ?)";

        try {
            pst = conn.prepareStatement(query);
            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setInt(3, phone);
            pst.setString(4, email);
            pst.setInt(5, salary);
            pst.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
    }
    
    
    public static boolean upload(int IDbk, String bookName, String stdname, String empname, String Email, String formattedBookDetDate, String formattedBookOutDate) {


        String query = "INSERT INTO book_loans (book_id,book_name, member_Name, employee_name, loan_date, due_date, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = DBConn.connect();
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(query);
            pst.setInt(1, IDbk);
            pst.setString(2, bookName);
            pst.setString(3, stdname);
            pst.setString(4, empname);
            pst.setString(5, formattedBookDetDate);
            pst.setString(6, formattedBookOutDate);
            pst.setString(7, Email);

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                return true;
            }
        } catch (SQLException e) {

            //    System.out.println(e);
        }

        return false; // Failed insertion
    }


}
