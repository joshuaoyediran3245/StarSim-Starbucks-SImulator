// The main looks like this for now since we dont have an interfece yet
// the first thing is displaying the options and taking input of which option
// they need to select a posible number a different one would put them back in the loop

import java.util.*;

public class main{

    public static void main(String[] args){
    
    // Here we get some of our objects and classe started

    Scanner scan = new Scanner(System.in);
    menu menu1 = new menu(); 
    register reg1 = new register();
    
    // Dislpay the temportal "interfece" so they can choose an option
    System.out.println("[Welcome to Starbucks!]");
    System.out.println("[How can we help you today?]");
    
    //Boolean to check that the program is done and it does not run it again
    boolean programFinished = false;
    int orderNumber = 1;

    while(!programFinished)
    {
        // We show the options and take the input, depending on the input the program will show the different otions
        System.out.println("[1] Place an Order");  
        System.out.println("[2] See History of Orders");  
        System.out.println("[3] Quit");  
        int decision = scan.nextInt();

        // Check that they are selecting a posible option

        while  ((decision!=1) && (decision!=2 ) && (decision!=3))
        {
        System.out.println("Invalid option");
        System.out.println("Please select on of the options");
        decision = scan.nextInt();
        
        }
        // Begin to display menu and construct order, max items 2,
        
        

        
        if(decision==1)
        {
           //Display the menu for drinks
            menu1.ListMenu();
            menu1.displayMenuDrinks();

            // Tells the customer that they can order max 2
            System.out.println("You can order up to 2 drinks");
            System.out.println("How many drinks would you like?");
            
            int count = scan.nextInt();
            String foodOrDrink;
            double price;

            // Loop for the amout of drinks that its ordered
            for(int i = 0; i<count;i++)
            {
                System.out.println("Select a drink");
                foodOrDrink= scan.next();
                
                //checks that we have the item in the menu
                while(!menu1.checkMenuDrink(foodOrDrink))
                {
                    System.out.println("It seems we dont have that iteam");
                    System.out.println("Plase select an item from the menu");
                    foodOrDrink = scan.next();
                }

                //add the price of the item and the item itself to the order
                price = menu1.getPriceDrink(foodOrDrink);
                reg1.additem(price, foodOrDrink,orderNumber);
                

            }

            //Display food menu
            menu1.displayFoodMenu();
            System.out.println("You can order up to 3 food items");
            System.out.println("How many food items would you like?");
            count= scan.nextInt();

            // Loop for the amout of drinks that its ordered
            for(int i = 0; i<count;i++)
            {
                System.out.println("Select a food item");
                foodOrDrink= scan.next();
                
                //checks that we have the item in the menu
                while(!menu1.checkMenuFood(foodOrDrink))
                {
                    System.out.println("It seems we dont have that iteam");
                    System.out.println("Plase select an item from the menu");
                    foodOrDrink = scan.next();
                }

                //add the price of the item and the item itself to the order
                price = menu1.getPriceFood(foodOrDrink);
                reg1.additem(price, foodOrDrink,orderNumber);

            }

            //Gives total and the customer goes back to the first loop, where the options are displayed again
            System.out.println("Your total today is: "+reg1.getTotal());
            System.out.println("[Your order is going to be ready in a moment]");
            System.out.println("[Select an option to continue]");
            // number of order goes up
            orderNumber++;
            // price of order in a arraylist with all the prices of different orders
            reg1.addPriceToOrder(reg1.getTotal());  

        }
        
        // Option to display past orders, still working on it, i need to figure out the way to have more than one order saved!
        else if(decision==2)
        {
            //Checks that there is al least 1 order, else it would not go pass that
            int pastOrders=reg1.getOrdersCount();
            if(pastOrders==0)
            {
                System.out.println("There is no history on previos orders");
                System.out.println("Please place an order first");
            }
            // Display the number of orders so the customer can select one
            else
            {
            reg1.displayPastOrders();
            int orderChoose = scan.nextInt();
            reg1.openSelectedOrder(orderChoose);
            }
        }
        
        // Exits the program
        else if(decision==3)
        {
            programFinished = true;
        }
    }   
}
}

