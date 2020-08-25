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

    public void addPizzaList(Pizza pizza, int amount) {
        for (int i = 0; i < amount; i++) {
            int AmoutOrder = this.pizzaList.size();
            Pizza p = null;
            if (i == 0) {
                p = pizza;
            } else {
                //using clone new object
                p = pizza.clone();
            }

            this.pizzaList.put((AmoutOrder + ""), p);
        }

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
        this.pizzaList = new HashMap<String, Pizza>();
    }

    public void paid() {
        Cashier c = Cashier.getCashier();
        double price = this.getPrice();
        System.out.println("Slip : \n "
                + "Slip Id : " + this.id + "\n"
                + "Customer : " + this.customer + "\n"
                + "price :" + price + "\n"
                + "====== order =========== \n");
        for (String id : this.pizzaList.keySet()) {
            System.out.println((id+1)+" "+this.pizzaList.get(id).getPzType()+ ' '+ this.pizzaList.get(id).getPzPrice());
        }
        this.isPaid = true;
        c.payBill(price);
        System.out.println("thank you take our pizza");

    }

}
