/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Customer;

import javax.swing.JFrame;

/**
 *
 * @author harlan
 */
public class NineAirlines {

    /**
     * @param args the command line arguments
     */
        // TODO code application logic here
    public JFrame frame;
    
    public static void main(String[] args) {
        A_LoginCustomer LoginCustomer = new A_LoginCustomer(); 
        LoginCustomer.setVisible(true);
        LoginCustomer.setLocationRelativeTo(null);
    }
}