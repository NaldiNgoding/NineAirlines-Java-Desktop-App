/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author harlan
 */
public class Koneksi {
    private static Connection koneksi;
    
    public static java.sql.Connection getConnection(){
        if(koneksi == null){
            try{
                String url = "jdbc:mysql://localhost:3306/nineairlines";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi=(Connection) DriverManager.getConnection(url, user, password);
                System.out.println("Connection Successfully");
            } catch (SQLException ex){
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE,null,ex);
            }
        }     
        return koneksi;
    }
}