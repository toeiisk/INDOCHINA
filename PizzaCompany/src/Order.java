/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hp
 */
import java.util.HashMap;
import javafx.util.Pair;

public class Order {

    static int currentId = 0;
    private int id;
    private HashMap<String, Pizza> pizzaList;
    private double price;
    private String customer;
    private boolean isPaid;

    public int getId() {
        return id;
    }

    public HashMap<String, Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(HashMap<String, Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public void addPizzaList(Pizza pizza) {
        int AmoutOrder = this.pizzaList.size();
        this.pizzaList.put((AmoutOrder + ""), pizza);
    }

    public double getPrice() {
        double cost = 0.0f;
        for (Pizza pizza : this.pizzaList.values()) {
            cost += pizza.getPzPrice();
        }
        return cost;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order(String customer) {
        this.id = ++Order.currentId;
        this.customer = customer;
        this.price = 0.0;
        this.isPaid = false;
    }

    public void paid() {
        Cashier c = Cashier.getCashier();
        double price = this.getPrice();
        System.out.println("Slip : \n "
                + "Slip Id : "+this.id+"\n"
                + "Customer : "+this.customer+"\n"
                + "price :"+price+"\n"
                + "====== order =========== \n");
        for (String id : this.pizzaList.keySet()) {
            System.out.println(id+" "+this.pizzaList.get(id).getPzName()+ ' '+ this.pizzaList.get(id).getPzPrice());
        }
        this.isPaid = true;
        c.payBill(price);
        System.out.println("thank you take our pizza");
        
       
    }

}
