// The main looks like this for now since we dont have an interfece yet
// the first thing is displaying the options and taking input of which option
// they need to select a posible number a different one would put them back in the loop

import java.util.*;
import java.util.Map;
public class main{

    public static void main(String[] args){
    
    // Here we get some of our objects and classe started

    Scanner scan = new Scanner(System.in);
    menu menu1 = new menu(); 
    register reg1 = new register();
    receipt rec1 = new receipt();
    // inventory inventory = new inventory(100, "Coffee Beans"); //Implementing the Inventory Class
    
    //
    menu1.ListMenu();
    Map<String,Double> mapForReceipt1 = menu1.mapPassDrinks();
    Map<String,Double> mapForReceipt2 = menu1.mapPassFood();
    
    rec1.MapReciverDrinks(mapForReceipt1);
    rec1.MapReciverFood(mapForReceipt2);

    // Dislpay the temportal "interfece" so they can choose an option
    System.out.println("[Welcome to Starbucks!]");
    System.out.println("[How can we help you today?]");
    
    //Boolean to check that the program is done and it does not run it again
    boolean programFinished = false;
    int orderNumber = 1;
    String receipt1;
    String checkNum;

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
            
            menu1.displayMenuDrinks();

            // Tells the customer that they can order max 2
            System.out.println("You can order up to 2 drinks");
            System.out.println("How many drinks would you like?");
            
            // checks for the right number of drinks in the order, the max is 2, no more than that
            checkNum = scan.next();
            while(!(checkNum.equals("0")||checkNum.equals("1")||checkNum.equals("2")))
            {
                System.out.println("Invalid option");
                System.out.println("Please select how many drinks would you like, up to 2 drinks");
                checkNum = scan.next();
            }
            
            int count = Integer.valueOf(checkNum);
            String foodOrDrink;
            double price;

            // Loop for the amout of drinks that its ordered
            for(int i = 0; i<count;i++)
            {
                System.out.println("Select a drink");
                foodOrDrink= scan.next();
                
                //checks that we have the item in the menu
                while(!menu1.checkMenuDrink(foodOrDrink.toLowerCase()))
                {
                    System.out.println("It seems we dont have that iteam");
                    System.out.println("Plase select an item from the menu");
                    foodOrDrink = scan.next();
                }

                //add the price of the item and the item itself to the order
                price = menu1.getPriceDrink(foodOrDrink.toLowerCase());
                reg1.additem(price, foodOrDrink.toLowerCase(),orderNumber);
                

            }

            //Display food menu
            menu1.displayFoodMenu();
            System.out.println("You can order up to 3 food items");
            System.out.println("How many food items would you like?");
            
            // checks for the right number of foods in the order, the max is 3, no more than that
            checkNum = scan.next();
            while(!(checkNum.equals("0")||checkNum.equals("1")||checkNum.equals("2")||checkNum.equals("3")))
            {
                System.out.println("Invalid option");
                System.out.println("Please select how many drinks would you like, up to 2 drinks");
                checkNum = scan.next();
            }
            

            count = Integer.valueOf(checkNum);

            // Loop for the amout of drinks that its ordered
            for(int i = 0; i<count;i++)
            {
                System.out.println("Select a food item");
                foodOrDrink= scan.next();
                
                //checks that we have the item in the menu
                while(!menu1.checkMenuFood(foodOrDrink.toLowerCase()))
                {
                    System.out.println("It seems we dont have that iteam");
                    System.out.println("Plase select an item from the menu");
                    foodOrDrink = scan.next();
                }

                //add the price of the item and the item itself to the order
                price = menu1.getPriceFood(foodOrDrink.toLowerCase());
                reg1.additem(price, foodOrDrink.toLowerCase(),orderNumber);

            }
                // add tip to the order
                System.out.println("[Would you like to leave a tip]");
                System.out.println("[$1][$2][$5][No]");
            checkNum = scan.next();
            while(!((checkNum.equals("1")||(checkNum.equals("2"))||(checkNum).equals("5")||(checkNum.toLowerCase()).equals("no"))))
            {
                System.out.println("Invalid option");
                System.out.println("Please select an amount for tip or No");
                checkNum = scan.next();
            }
            
            reg1.addPriceToOrder(reg1.getTotal()); 
            Double tip = rec1.saveTip(checkNum.toLowerCase());
            
            
            //Gives total and the customer goes back to the first loop, where the options are displayed again
            System.out.println("[Your total today is: $"+String.format("%.2f",(reg1.getTotalOfAnOrder(orderNumber)+tip))+"]");
            System.out.println("[Your order is going to be ready in a moment]");
             

            //ask if they want a printed receipt
            System.out.println("[Would you like a receipt?]");
            System.out.println("[Yes][No]");

            checkNum = scan.next();
            while(!((checkNum.toLowerCase()).equals("yes")||(checkNum.toLowerCase()).equals("no")))
            {
                System.out.println("Invalid option");
                System.out.println("Please insert yes or no");
                checkNum = scan.next();
            }

            if(checkNum.toLowerCase().equals("yes"))
            {
            receipt1 = rec1.printReceipt((reg1.passOrderToReceipt(orderNumber)), orderNumber, reg1.getTotalOfAnOrder(orderNumber));
            System.out.println(receipt1);

            }
            
            

            System.out.println("[Select an option to continue]");
            // number of order goes up
            orderNumber++;
            // price of order in a arraylist with all the prices of different orders
            


            //Updating the inventory based on the items ordered 
            // inventory.ingredientsUsed(reg1.getIngredientsUsed(orderNumber)); //Not in Use for now

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
            
            //Checks that it is a posible integer, by first taking the string, converting to integer and checking the range, which is the num of orders
            String orderChoose = scan.next();
            while(((Integer.valueOf(orderChoose))<=0)||((Integer.valueOf(orderChoose))>reg1.getOrdersCount()))
            {
            System.out.println("Invalid order number");
            System.out.println("Please select a valid number for an order ");
            orderChoose = scan.next();
            }


            reg1.openSelectedOrder(Integer.valueOf(orderChoose));
            System.out.println("[Your total for this order is: $"+(reg1.getTotalOfAnOrder(Integer.valueOf(orderChoose))+rec1.getTip(Integer.valueOf(orderChoose)))+"]");
            //ask if they want a printed receipt
            System.out.println("[Would you like a receipt for the order selected?]");
            System.out.println("[yes][no]");

            checkNum = scan.next();
            while(!((checkNum.toLowerCase()).equals("yes")||(checkNum.toLowerCase()).equals("no")))
            {
                System.out.println("Invalid option");
                System.out.println("Please insert yes or no");
                checkNum = scan.next();
            }

            if(checkNum.toLowerCase().equals("yes"))
            {
            
            orderNumber=Integer.valueOf(orderChoose);
            receipt1 = rec1.printReceipt((reg1.passOrderToReceipt(orderNumber)), orderNumber,reg1.getTotalOfAnOrder(orderNumber));
            System.out.println(receipt1);

            }


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
