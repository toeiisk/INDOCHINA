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
                    System.out.println("========New Order======\n Inout Customer name : ");
                    String customerName = myObj.nextLine();
                    Order newOrder = new Order(customerName);
                    System.out.println("Order no. "+newOrder.getId()+ " was created, next select pizza, finish press 'pay'");
                    String type = "";
                    while(type.equals("pay")){
                        System.out.println("Chicken Delux (press C) MighyMeat {press M} : ");
                        type = myObj.nextLine();
                        switch(type){
                            case "M":
                                MightyMeat m = new MightyMeat();
                                System.out.println("select Size : S M L XL");
                                type = myObj.nextLine();
                                m.setPzSize(type);
                                System.out.println("select Toping : H(Ham) S(Sausage) HS(both) N(No topping)");
                                type = myObj.nextLine();
                                if(type.contains("HS")){
                                   m.setIsHam(true);
                                   m.setIsSausage(true);
                                }
                                else if(type.indexOf('H') != -1){
                                   m.setIsHam(true);
                                }else if(type.indexOf('S') != -1){
                                    m.setIsSausage(true);
                                }
                                
                                
                                break;
                            case "C":
                                ChickenDeluxe c = new ChickenDeluxe();
                                System.out.println("select Size : S M L XL");
                                type = myObj.nextLine();
                                c.setPzSize(type);
                                System.out.println("select Toping : R(RoastChicken) BQ(BBQChicken) B(both) N(No topping)");
                                type = myObj.nextLine();
                                switch(type){
                                    case "R":
                                        break;
                                    case "BQ":
                                        break;
                                    case "B":
                                        break;
                                    case "N":
                                        break;
                                    default:
                                        break;
                                }
                                
                                break;
                                
                            default:
                                break;
                        }
                        
                        
                        
                        
                    }
                    
                    
                    
                    
                    
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
