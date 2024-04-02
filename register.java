// Insted of using a transaction class, lets use a register one that collects num of items, total price and an arraylist with the String name of the items.
// This class also has methods to read information and to write information in a file
import java.util.ArrayList;


public class register implements shoppingHistory {
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
    return Double.valueOf((String.format("%.2f",totalPrice*tax)));
}

// Count item, we did not use it
public int getOrdersCount() 
{
    return ordersPlaced.size();
}

// Implements displayPastOrders 
public void displayPastOrders()
{
    //Strings all the name of the items in the order toghether
    System.out.println("[There is "+ ordersPlaced.size()+" orders]");
    System.out.println("[Select the number of the order to view]");
    for(int i = 0; i<ordersPlaced.size();i++)
    {
        if(i==0)
        {
        System.out.print("[Order Number:"+(i+1)+"]");
        }
        else
        {
            System.out.print(" [Order Number:"+(i+1)+"]");  
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
            listForView=listForView+", "+listOfItems.get(i);
        }
    }
    System.out.println("[Items in the order: "+listForView+"]");
}

// Add price of the order to an arraylist and it has the same index of the number of order, It cleans the variable totalPrice so another other starts from $0
public void addPriceToOrder(double price)
{
    pricesOfOrders.add(price);
    totalPrice=0;
}

// Pass list of the items in a order so the receipt class can use it
public ArrayList<String> passOrderToReceipt(int orderNumber)
{ 
ArrayList<String> listOfItems = new ArrayList<String>();
for(String element :(ordersPlaced.get(orderNumber-1)))
    {
        listOfItems.add(element);
    }
return listOfItems;
}

// Gets total of a specific order
public double getTotalOfAnOrder(int orderNumber)
{
    return pricesOfOrders.get(orderNumber-1);
}

// add tip to the total of a specific order
public void addtipToTotal(Double tip, int orderNumber)
{
    pricesOfOrders.set(orderNumber-1,pricesOfOrders.get(orderNumber-1)+tip);
}

// Adds order from file that it was read
public void addOrderFromFile(ArrayList<String> lista)
{
    ordersPlaced.add(lista);
}

// returns the list of list of items
public ArrayList<ArrayList<String>> fileOrdersPlaced()
{
    return this.ordersPlaced;
}

// returns the total of the all orders that are in the program
public ArrayList<Double> fileTotalOfOrders()
{
    return this.pricesOfOrders;
}
}
