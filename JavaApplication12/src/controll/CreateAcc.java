///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

package controll;

import Model.Create;
import javax.swing.JOptionPane;

/**
 * @author sanam
 */
public class CreateAcc {
    public void createaccount(String name, String password, String email) {
        boolean status = Create.CreateAcc(name, email, password);
        System.out.println(name);
        if (status) {
            JOptionPane.showMessageDialog(null, "Welcome " + name);
        } else {
            JOptionPane.showMessageDialog(null, "Enter valid Email and Password", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

}
