/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB304_28
 */

//ovenStatus = "AVAILABLE", "BAKING", "BAKED"
public class PizzaOven {
    private String ovenStatus;
    private int timeRemaining;
    private Pizza pizzaInOven;
    
    public PizzaOven() {
        this.ovenStatus = "AVAILABLE";
        this.timeRemaining = 0;
    }

    /**
     * @return the ovenStatus
     */
    public String getOvenStatus() {
        return ovenStatus;
    }

    /**
     * @param ovenStatus the ovenStatus to set
     */
    public void setOvenStatus(String ovenStatus) {
        this.ovenStatus = ovenStatus;
    }

    /**
     * @return the timeRemaining
     */
    public int getTimeRemaining() {
        return timeRemaining;
    }

    /**
     * @param timeRemaining the timeRemaining to set
     */
    public void setTimeRemaining(int timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
    
    public void Bake(Pizza pizza, int bakeTime) {
        this.pizzaInOven = pizza;
        this.timeRemaining = bakeTime;
        this.ovenStatus = "BAKING";
    }
    
    public void Baking() {
        if (this.pizzaInOven != null && this.timeRemaining > 0) {
            this.timeRemaining -= 1;
            if (this.timeRemaining <= 0) {
                this.ovenStatus = "BAKED";
                this.pizzaInOven.setPzStatus("BAKED");
            }
        }
    }
    
    public void getStatus(){
        if ("AVAILABLE".equals(this.ovenStatus)) {
            System.out.println("THIS OVEN IS AVAILABLE !");
        } else {
            System.out.println("THIS OVEN IS " + this.getOvenStatus() + 
                    " ( Pizza ) SIZE : " + this.pizzaInOven.getPzSize() +
                    " TYPE : " + this.pizzaInOven.getPzType() +
                    "STATUS : "+ this.pizzaInOven.getPzStatus());
        }
    }
    
}
