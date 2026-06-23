package dao;

import Customer.Koneksi;
import model.Model_Seat;
import service.Service_Seat;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class DAO_Seat implements Service_Seat {
    private Connection conn;
    
    public DAO_Seat() {
        conn = Koneksi.getConnection();
    }

    @Override
    public void getSeat(Model_Seat modelSeat) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String sql = "SELECT seat FROM booking WHERE route = ? AND (LEFT(date, 10) = LEFT(?, 10) AND RIGHT(date, 4) = RIGHT(?, 4))";
        
        try {
            st = conn.prepareStatement(sql);
            String route = modelSeat.getRoute();
            String date = modelSeat.getDate();
            
            st.setString(1, route);
            st.setString(2, date);
            st.setString(3, date);
            
            rs = st.executeQuery();
            ArrayList<String> seats = new ArrayList<>();
            while (rs.next()) {
                seats.add(rs.getString("seat"));
            }
            
            // Assuming Model_Seat has a method to set seats
            modelSeat.setSeats(seats);
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Seat.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Failed to retrieve seats", "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Seat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DAO_Seat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
