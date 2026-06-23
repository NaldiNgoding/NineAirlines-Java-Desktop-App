package dao;

import Customer.Koneksi;
import model.Model_Booking;
import service.Service_Booking;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class DAO_Booking implements Service_Booking{
    private Connection conn;
    
    public DAO_Booking(){
        conn = Koneksi.getConnection();
    }

    public void insertBooking(Model_Booking modelBooking) {
        PreparedStatement st = null;
        String sql = "INSERT INTO booking (f_name, l_name, no_passport, route, date ,seat, amount) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, modelBooking.getFname());
            st.setString(2, modelBooking.getLname());
            st.setString(3, modelBooking.getNpassport());
            st.setString(4, modelBooking.getRoute());
            st.setString(5, modelBooking.getDate());
            st.setString(6, modelBooking.getBook());
            st.setDouble(7, modelBooking.getAmount());
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Booking inserted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Booking.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Failed to insert booking", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
