/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controll;


import Model.Read;
import Model.Update;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @author sanam
 */
public class BookCheckIn {

    public void getBookd(JLabel stdname, JLabel bookid, int ID) {
        try {
            ResultSet rs = Read.chekIn(ID);
            if (rs.next()) {
                bookid.setText(rs.getInt("book_id") + "");
                stdname.setText(rs.getString("member_Name"));

            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Book Check out Failed ", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Handle SQL exception
        }
    }


    public void checkin(JLabel stdname, JTextField ckekinid, Date bookOutDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
            String formattedBookDetDate = sdf.format(bookOutDate);
            int id = Integer.parseInt(ckekinid.getText());
            if (!(ckekinid.getText().equals("") && stdname.getText().equals("") && formattedBookDetDate.equals(""))) {
                boolean status = Update.checkin(id, formattedBookDetDate);
                if (status) {
                    JOptionPane.showMessageDialog(null, "Book Check In successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Book Check in Failed ", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void loadtable(JTable books) {
        ResultSet rs = Read.loadTable("book_loans");
        try {
            DefaultTableModel td = (DefaultTableModel) books.getModel();
            td.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                v.add(rs.getString("id"));
                v.add(rs.getString("book_id"));
                v.add(rs.getString("book_name"));
                v.add(rs.getString("member_Name"));
                v.add(rs.getString("email"));
                v.add(rs.getString("employee_name"));
                v.add(rs.getString("loan_date"));
                v.add(rs.getString("due_date"));
                v.add(rs.getString("rutern_date"));


                td.addRow(v);
            }
        } catch (Exception e) {

        }

    }

}
