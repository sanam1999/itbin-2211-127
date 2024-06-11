/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controll;

import Model.Create;
import Model.Delete;
import Model.Read;
import Model.Update;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


/**
 * @author sanam
 */
public class Book {

    public static void delete(JLabel id, JTable emptable) {

        String i = id.getText().trim();

        if (i.equals("")) {
              JOptionPane.showMessageDialog(null, "Select Book", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Book bk = new Book();
            int response = JOptionPane.showConfirmDialog(null, "Do you want to delete the book with ID " + i + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                int ID = Integer.parseInt(i);
                bk.delete(ID);
                LoadTabl(emptable);

            }
        }
    }

    public static void LoadTabl(JTable books) {
        ResultSet rs = Read.loadTable("books");
        try {
            DefaultTableModel td = (DefaultTableModel) books.getModel();
            td.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("name"));
                v.add(rs.getString("edition"));
                v.add(rs.getString("pages"));
                v.add(rs.getString("price"));
                v.add(rs.getString("publisher"));
                v.add(rs.getString("selected"));
                td.addRow(v);
            }
        } catch (Exception e) {

        }
    }

 

    public void update(int id, String bookName, String bookEdition, String bookPage, String bookPrice, String bookPublisher, String selectedOption) {
        boolean status = Update.update(id, bookName, bookEdition, bookPage, bookPrice, bookPublisher, selectedOption);

        if (status) {
            JOptionPane.showMessageDialog(null, "Update successful");
        } else {
            JOptionPane.showMessageDialog(null, "Update failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int id) {
        boolean status = Delete.delete(id, "books");

        if (status) {
            JOptionPane.showMessageDialog(null, "Delete successful");
        } else {
            JOptionPane.showMessageDialog(null, "Delete failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void add(JTextField bname, JTextField edition, JTextField page, JTextField price, JTextField publisher, JComboBox<String> selector) {
       String bookName = bname.getText();
        bname.setText("");
        String bookEdition = edition.getText();
        edition.setText("");
        String bookPage = page.getText();
        page.setText("");
        String bookPrice = price.getText();
        price.setText("");
        String bookPublisher = publisher.getText();
        publisher.setText("");
        String selectedOption = (String) selector.getSelectedItem();
        
     
        if (bookName.equals("")) {
             JOptionPane.showMessageDialog(null, "Enter values for add Books", "Error", JOptionPane.ERROR_MESSAGE);
            
        } else {
             boolean status = Create.addDB(bookName, bookEdition, bookPage, bookPrice, bookPublisher, selectedOption);

        if (status) {
            JOptionPane.showMessageDialog(null, "Record added successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add record", "Error", JOptionPane.ERROR_MESSAGE);
        }
        }

    }

    public int getid(String books) {
    return Read.getid("books");
    }
}   


