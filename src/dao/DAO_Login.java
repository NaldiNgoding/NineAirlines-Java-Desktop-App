/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import Customer.A_LoginCustomer;
import Customer.B_Destination;
import Customer.Koneksi;
import java.sql.Blob;
import model.Model_Login;
import service.Service_Login;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author 62838
 */
public class DAO_Login implements Service_Login{
    private Connection conn;
    
    public DAO_Login(){
        conn = Koneksi.getConnection();
    }

    @Override
    public void prosesLogin(Model_Login mod_login) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String Nama = null;
        String Username = null;
        String sql = "SELECT * FROM customer WHERE username=? AND password=?";
    
    try {
        st = conn.prepareStatement(sql);
        st.setString(1, mod_login.getUsername());
        st.setString(2, mod_login.getPassword());
        
        rs = st.executeQuery();
        if (rs.next()) {
            Nama = rs.getString("F_name");
            Blob gambarBlob = rs.getBlob("gambar");
            Username = rs.getString("username");
            
            Model_Login mod = new Model_Login();
            mod.setNama(Nama);
            mod.setGambar(gambarBlob);
            mod.setUsername(Username);
            
            B_Destination menu = new B_Destination(mod);
            menu.setVisible(true);
            menu.revalidate();
            
            A_LoginCustomer lg = new A_LoginCustomer();
            lg.tutup = true;  
        } else {
            JOptionPane.showMessageDialog(null, "Username dan Password salah", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            A_LoginCustomer lg = new A_LoginCustomer();
            lg.tutup = false; 
        }
    } catch (SQLException ex) {
        Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO_Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }}