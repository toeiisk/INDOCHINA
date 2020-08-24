

public class Cashier {

        // static variable single_instance of type Singleton 
    private static Cashier single_instance = null;

    // variable of type String 
    public String employee;
    public double cash;
    

    // private constructor restricted to this class itself 
    private Cashier() {
        employee = "Pound";
        cash = 0.0;
    }

    // static method to create instance of Singleton class 
    public static Cashier getCashier() {
        // To ensure only one instance is created 
        if (single_instance == null) {
            single_instance = new Cashier();
        }
        return single_instance;
    }
    
    public boolean getOrder(String OrderId) {
        return true;
    }
    public void payBill(String OrderId, double cash){
        this.cash += cash;  
    }

}
