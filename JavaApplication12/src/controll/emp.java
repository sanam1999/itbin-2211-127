/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controll;

import Model.Create;
import Model.Read;
import Model.Delete;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 * @author sanam
 */
public class emp {

    public static void delete(JTable emptable) {
        int r = emptable.getSelectedRow();
        System.out.println(r);
        if (r == -1) {
            JOptionPane.showMessageDialog(null, "Select an employee to delete", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String i = emptable.getValueAt(r, 0).toString();

            emp e = new emp();
            int response = JOptionPane.showConfirmDialog(null, "Do you want to delete Employee " + i + "?", "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.YES_OPTION) {
                try {
                    int ID = Integer.parseInt(i);
                    e.delete(ID);
                    emp lod = new emp();

                    lod.LoadTabl(emptable);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid employee ID");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error deleting employee: " + ex.getMessage());
                }
            }
        }
    }


    public void add(String fname, String lname, int phone, String email, int salary) {

        boolean status = Create.addEpm(fname, lname, phone, email, salary);

        if (status) {
            JOptionPane.showMessageDialog(null, "Employee added successfully");
        } else {
            JOptionPane.showMessageDialog(null, "Failed to add Employee", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(int id) {
        boolean status = Delete.delete(id, "employee");

        if (status) {
            JOptionPane.showMessageDialog(null, "Delete successful");
        } else {
            JOptionPane.showMessageDialog(null, "Delete failed", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void LoadTabl(JTable emptable) {
        ResultSet rs = Read.loadTable("employee");


        try {
            DefaultTableModel td = (DefaultTableModel) emptable.getModel();
            td.setRowCount(0);
            System.out.println("out wile");
            while (rs.next()) {
                Vector<Object> v = new Vector<>();
                v.add(rs.getInt("id"));
                v.add(rs.getString("first_name"));
                v.add(rs.getString("last_name"));
                v.add(rs.getString("email"));
                v.add(rs.getInt("phone_number"));
                v.add(rs.getInt("salary"));
                td.addRow(v);
            }
        } catch (Exception e) {

        }
    }

    public int getid(String employee) {
      return Read.getid("employee");
    }

}
