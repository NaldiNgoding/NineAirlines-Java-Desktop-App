/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author harlan
 */

public class Flight extends Seat {

    private static Seat[] seat = new Seat[42];

    public Flight() {
        String[] label = new String[]{"A", "B", "C", "D", "E", "F"};
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 7; j++) {
                int x = (7 * (i - 1)) + (j - 1);
                this.seat[x] = new Seat(label[i - 1] + "" + j);
            }
        }
    }

    public boolean[] getAvailableStatus() {
        boolean[] availableStatus = new boolean[42];
        for (int i = 0; i < 42; i++) {
            availableStatus[i] = seat[i].isAvailable();
        }
        return availableStatus;
    }

    public int countAvailable() {
        int availableCount = 0;
        for (int i = 0; i < 42; i++) {
            if (seat[i].isAvailable()) {
                availableCount++;
            }
        }
        return availableCount;
    }

    public boolean bookSeat(String seatNo, String firstName, String lastName, String passportNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return seat[i].book(firstName, lastName, passportNo);
            }
        }
        return false;
    }
    
    public void cancelSeat(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                seat[i].reset();
            }
        }
    }    

    public boolean getSeatStatus(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return seat[i].isAvailable();
            }
        }
        return false;
    }

    public String getSeatInfo(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return ("#### PASSENGER INFO #### " + " \n Seat: " + seat[i].getSeatNo() + " \n Full Name: "
                        + seat[i].getFullName() + " \n Passport No: " + seat[i].getPassportNo()
                        + "\n#### successfully booked #### ");
            }
        }
        return "#### PASSENGER INFO : error returning passenger info";
    }

    public String getSeatSeatNo(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return (seat[i].getSeatNo());
            }
        }
        return "Error returning getSeatSeatNo";
    }

    public String getSeatFirstName(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return (seat[i].getFirstName());
            }
        }
        return "Error returning getSeatFirstName";
    }

    public String getSeatLastName(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return (seat[i].getLastName());
            }
        }
        return "Error returning getSeatLastName";
    }

    public String getSeatPassportNo(String seatNo) {
        for (int i = 0; i < 42; i++) {
            if (seat[i].getSeatNo().equals(seatNo)) {
                return (seat[i].getPassportNo());
            }
        }
        return "Error returning getSeatPassportNo";
    }
}