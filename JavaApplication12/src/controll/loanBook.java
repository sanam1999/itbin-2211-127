/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controll;

import Model.Create;
import Model.Read;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.bookcheckin;

/**
 * @author sanam
 */
public class loanBook {

    public void LoadTabl(JTable books) {
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

        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void upload(int IDbk, String bookName, String stdname, String empname, String Email, String formattedBookDetDate, String formattedBookOutDate) {
        boolean status = Create.upload(IDbk, bookName, stdname, empname, Email, formattedBookDetDate, formattedBookOutDate);

        if (status) {
            JOptionPane.showMessageDialog(null, "Book Check Out Successful");
            bookcheckin ch = new bookcheckin();
            ch.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(null, "Invalid details", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void combobox(JComboBox<String> selector) {
          ResultSet rs = Read.getname();
        try {
            while (rs.next()) {
                selector.addItem(rs.getNString("first_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }

    public int getID(String book_loans) {
        return  Read.getid("book_loans");
    }


}
