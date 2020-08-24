
import java.util.Scanner;  // Import the Scanner class
public class Cashier {

        // static variable single_instance of type Singleton 
    private static Cashier single_instance = null;

    // variable of type String 
    private String employee;
    private double cash;
    

    // private constructor restricted to this class itself
    
    Cashier(){
        this.employee = "";
        this.cash = 0.0f;
    }
    Cashier(String name, double cash) {
        this.employee = name;
        this.cash = cash;
    }

    // static method to create instance of Singleton class 
    public static Cashier getCashier() {
        // To ensure only one instance is created 
        if (single_instance == null) {
            single_instance = new Cashier();
        }
        return single_instance;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
    
    public boolean getOrder(String OrderId) {
        return true;
    }
    public void payBill(double cash){
        this.cash += cash;  
    }

}
