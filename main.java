// The main looks like this for now since we dont have an interfece yet
// the first thing is displaying the options and taking input of which option
// they need to select a posible number a different one would put them back in the loop

import java.util.*;

public class main{

    public static void main(String[] args){
    
    // Here we get some of our objects and classe started

    Scanner scan = new Scanner(System.in);
    menu menu1 = new menu(); 
    
    // Dislpay the temportal "interfece" so they can choose an option
    
    System.out.println("[Welcome to Starbucks!]");
    System.out.println("[How can we help you today?]");
    System.out.println("[1] Place an Order");  
    System.out.println("[2] See History of Orders");  
    System.out.println("[3] Quit");  
    int decision = scan.nextInt();

    boolean orderfinished = false;

    while(!orderfinished)
    {
        // Check that they are selecting a posible option

        while  ((decision!=1) && (decision!=2 ) && (decision!=3))
        {
        System.out.println("Invalid option");
        System.out.println("Please select on of the options");
        decision = scan.nextInt();
        
        }
        // Begin to display menu and construct order

        if(decision==1)
        {
           
           menu1.ListMenu();
           menu1.displayMenu();

            orderfinished = true;
           


        }

        

    }   


}

}