/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Customer;

/**
 *
 * @author harlan
 */
public class Seat {
    private String seatNo;
    private boolean isAvailable;
    private String firstName;
    private String lastName;
    private String passportNo;

    public Seat() {
    }

    public Seat(String seatNo) {
        this.seatNo = seatNo;
        this.isAvailable = true;
        this.firstName = "";
        this.lastName = "";
        this.passportNo = "";
    }

    public String getSeatNo() {
        return this.seatNo;
    }

    public boolean isAvailable() {
        return this.isAvailable;
    }
    
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getPassportNo() {
        return this.passportNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public boolean book(String firstName, String lastName, String passportNo) {
        if (this.isAvailable) {
            this.isAvailable = false;
            this.firstName = firstName;
            this.lastName = lastName;
            this.passportNo = passportNo;
            return true;
        }
        return false;
    }

    public void reset() {
        this.isAvailable = true;
        this.firstName = "";
        this.lastName = "";
        this.passportNo = "";
    }
}

