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
            String Input = myObj.nextLine();
            switch (Input) {
                case "N":
                    // code block
                    System.out.println("========New Order======\n Inout Customer name : ");
                    String customerName = myObj.nextLine();
                    Order newOrder = new Order(customerName);
                    System.out.println("Order no. "+newOrder.getId()+ " was created, next select pizza, finish press 'pay'");
                    String type = "";
                    double price = 0.0f;
                    while(!type.equals("pay")){
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
                                //input price
                                price = myObj.nextDouble();
                                m.setPzPrice(price);
                                
                                
                                
                                         
                                break;
                            case "C":
                                ChickenDeluxe c = new ChickenDeluxe();
                                System.out.println("select Size : S M L XL");
                                type = myObj.nextLine();
                                c.setPzSize(type);
                                System.out.println("select Toping : R(RoastChicken) B(BBQChicken) BR(both) N(No topping)");
                                type = myObj.nextLine();
                                if(type.contains("BR")){
                                   c.setIsBbqChickenAmount(true);
                                   c.setIsRoastedChicken(true);
                                }
                                else if(type.indexOf('R') != -1){
                                   c.setIsRoastedChicken(true);
                                }else if(type.indexOf('B') != -1){
                                   c.setIsBbqChickenAmount(true);
                                }
                                //input price
                                price = myObj.nextDouble();
                                c.setPzPrice(price);
                                
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
            }else{
                System.out.println("Press 'N' to new order || Press 'C' check OvenStatus || Press 'exit' to exit program ");
            }
            
        }

    }

}
