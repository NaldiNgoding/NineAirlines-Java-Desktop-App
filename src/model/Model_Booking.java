/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
/**
 *
 * @author harlan
 */
public class Model_Booking {
    private String f_name;
    private String l_name;
    private String no_passport;
    private String route;
    private String book;
    private String date;
    private Double amount;
    
    public String getFname(){
        return f_name;
    }
    
    public void setFname(String f_name){
        this.f_name = f_name;
    }
    
    public String getLname(){
        return l_name;
    }
    
    public void setLname(String l_name){
        this.l_name = l_name;
    }
    
    public String getNpassport(){
        return no_passport;
    }
    
    public void setNpassport(String no_passport){
        this.no_passport = no_passport;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    public Double getAmount(){
        return amount;
    }
    
    public void setAmount(Double amount){
        this.amount = amount;
    }
}
