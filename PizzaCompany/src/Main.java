/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LAB304_28
 */
import java.util.Scanner;  // Import the Scanner class

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hello Welcome To INDOCHINA small pizza restaurant");

        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Cashire Name =>");
        String CashireName = myObj.nextLine();
        System.out.println("Enter Cash Now =>");
        double CashNow = myObj.nextDouble();

        Cashier currentCashier = new Cashier(CashireName, CashNow);
        System.out.println("Hi " + currentCashier.getEmployee() + ", Cash is " + currentCashier.getCash() + " Bath");

        while (true) {
            System.out.println("Press 'n' to new order || Press 'c' check OvenStatus || Press 'exit' to exit program ");
            String Input = myObj.nextLine();
            switch (Input) {
                case "N":
                    // code block
                    System.out.println("New Order");
                    break;
                case "C":
                    // code block
                    System.out.println("Oven Status");
                    break;
                case "exit":
                    // code block
                    Input = "Exit";
                    System.out.println("Exit Program");
                    break;
                    
            }
            if(Input.equals("Exit")){
                break;
            }
            
        }

    }

}
