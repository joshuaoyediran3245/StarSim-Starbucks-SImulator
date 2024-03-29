// Insted of using a transaction class, lets use a register one that collects num of items, total price and an arraylist with the String name of the items.
import java.util.ArrayList;


public class register {
// For now this are the private variables, we can add more, im still figuring out how to do it better
    
private double totalPrice;
    private ArrayList<ArrayList<String>> ordersPlaced = new ArrayList<ArrayList<String>>();
    private ArrayList<String> temporalList= new ArrayList<String>();
    private ArrayList<Double> pricesOfOrders = new ArrayList<Double>();
    private double tax = 1.21;



// add item with price and name
public void additem(double price, String item, int orderNumber)
{
    totalPrice+= price;
    
    if(orderNumber > ordersPlaced.size())
    {
        temporalList.clear();
        temporalList.add(item);
        ordersPlaced.add(temporalList);

    }
    else
    {
        temporalList.add(item);
    }


}
// Gives total value of order
public double getTotal()
{
    return totalPrice*tax;
}
// Count item, we did not use it, we can use it in the future
public int getOrdersCount() 
{

    return ordersPlaced.size();
}
// Display if there is a past order, it wont if there is nothing
public void displayPastOrders()
{
    //Strings all the name of the items in the order toghether
    System.out.println("[There is "+ ordersPlaced.size()+" orders]");
    System.out.println("[Which one would you like to view?]");
    for(int i = 0; i<ordersPlaced.size();i++)
    {
        if(i==0)
        {
        System.out.print("[Order Number:"+(i+1)+"]");
        }
        else
        {
            System.out.print(",[Order Number:"+(i+1)+"]");  
        }
    }
    System.out.println("");
}
// Put the order together in a String and prints the String of the order with the total price from the array pricesOfOrders
public void openSelectedOrder(int orderNumber)
{
    ArrayList<String> listOfItems = new ArrayList<String>();
    for(String element :(ordersPlaced.get(orderNumber-1)))
    {
    listOfItems.add(element);
    }
    String listForView="";
    for(int i =0;i<listOfItems.size();i++)
    {
        if(i==0)
        {
            listForView=listOfItems.get(i);
        }
        else
        {
            listForView=listForView+","+listOfItems.get(i);
        }
        
    }

    System.out.println("[Items on the order: "+listForView+"]");

}
// Add price of the order to an arraylist and it has the same index of the number of order, It cleans the variable totalPrice so another other starts from $0
public void addPriceToOrder(double price)
{
    pricesOfOrders.add(price);
    totalPrice=0;
}

public ArrayList<String> passOrderToReceipt(int orderNumber)

{
    
ArrayList<String> listOfItems = new ArrayList<String>();
for(String element :(ordersPlaced.get(orderNumber-1)))
    {
    listOfItems.add(element);
    }
return listOfItems;
}

//New method to get ingredients used in a specific order , Not in use for now
/* 
public ArrayList<String> getIngredientsUsed(int orderNumber) 
{
    ArrayList<String> ingredients = new ArrayList<>(); 

    if (orderNumber > 0 && orderNumber <= ordersPlaced.size()) {
        ingredients.addAll(ordersPlaced.get(orderNumber - 1));
    }
    return ingredients;
}
*/

public double getTotalOfAnOrder( int orderNumber)
{
    return pricesOfOrders.get(orderNumber-1);
}

public void addtipToTotal(Double tip, int orderNumber)
{
    pricesOfOrders.set(orderNumber-1,pricesOfOrders.get(orderNumber-1)+tip);
}
}
