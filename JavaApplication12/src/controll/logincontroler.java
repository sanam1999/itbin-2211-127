/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controll;


import Model.Read;
import view.Home;


import javax.swing.JOptionPane;

import view.Login;

/**
 * @author sanam
 */
public class logincontroler {
    public void login(String email, String password) {
        if (!(email.equals("") && password.equals(""))) {
            boolean Status = Read.chackUser(email, password);
            if (Status) {

                Home h1 = new Home();
                h1.setVisible(true);
                h1.pack();
                h1.setLocationRelativeTo(null);


            } else {
                Login l1 = new Login();
                l1.setVisible(true);
                JOptionPane.showMessageDialog(null, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);

            }
        } else {
            Login l = new Login();
            l.setVisible(true);
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);

        }


    }
}
